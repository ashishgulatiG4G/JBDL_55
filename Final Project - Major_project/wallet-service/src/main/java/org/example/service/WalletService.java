package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.CommonConstants;
import org.example.model.Wallet;
import org.example.repository.WalletRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    private static final String USER_CREATED_TOPIC = "user_created";
    private static final String TRANSACTION_CREATED_TOPIC = "transaction_created";

    private static final String WALLET_UPDATED_TOPIC = "wallet_updated";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("${wallet.initial.balance}")
    Long balance;

    /**
     * User onboarding flow
     *       CommonConstants.USER_CREATED_TOPIC -> This way we can move constants to a separate module (util)
     *       Make sure to add a dependency on utils module in pom.xml
     */

    @KafkaListener(topics = {CommonConstants.USER_CREATED_TOPIC}, groupId = "jbdl123")
    public void createWallet(String msg) throws ParseException {

        JSONObject obj = (JSONObject) new JSONParser().parse(msg);

        String walletId = (String)obj.get("phone");

        Wallet wallet = Wallet.builder()
                .walletId(walletId)
                .currency("INR")
                .balance(balance)
                .build();

        walletRepository.save(wallet);

        //TODO = Publish an event of wallet_created and send out a notification to the user

    }

    // User transaction flow
    @KafkaListener(topics = {TRANSACTION_CREATED_TOPIC}, groupId = "jbdl123")
    public void updateWallets(String msg) throws ParseException, JsonProcessingException {

        JSONObject obj = (JSONObject) new JSONParser().parse(msg);

        String receiverWalletId = (String) obj.get("receiverId");
        String senderWalletId = (String) obj.get("senderId");
        Long amount = (Long) obj.get("amount");
        String transactionId = (String) obj.get("transactionId");

        try {

            Wallet senderWallet = walletRepository.findByWalletId(senderWalletId);
            Wallet receiverWallet = walletRepository.findByWalletId(receiverWalletId);


            if (senderWallet == null || receiverWallet == null || senderWallet.getBalance() < amount) {
                obj = this.init(receiverWalletId, senderWalletId, amount, transactionId, "FAILED");
                obj.put("senderWalletBalance", senderWallet == null ? 0 : senderWallet.getBalance());

                kafkaTemplate.send(WALLET_UPDATED_TOPIC, objectMapper.writeValueAsString(obj));
                return;
            }

            walletRepository.updateWallet(senderWalletId, -amount);
            walletRepository.updateWallet(receiverWalletId, amount);

            obj = this.init(receiverWalletId, senderWalletId, amount, transactionId, "SUCCESS");

            kafkaTemplate.send(WALLET_UPDATED_TOPIC, objectMapper.writeValueAsString(obj));

        }catch (Exception e){
            obj = this.init(receiverWalletId, senderWalletId, amount, transactionId, "FAILED");
            obj.put("errorMsg", e.getMessage());

            kafkaTemplate.send(WALLET_UPDATED_TOPIC, objectMapper.writeValueAsString(obj));
        }



    }

    private JSONObject init(String receiverId, String senderId, Long amount,
                            String transactionId, String status){
        JSONObject obj = new JSONObject();
        obj.put("transactionId", transactionId);
        obj.put("senderWalletId", senderId);
        obj.put("receiverWalletId", receiverId);
        obj.put("amount", amount);
        obj.put("status", status);
        return obj;

    }
}
