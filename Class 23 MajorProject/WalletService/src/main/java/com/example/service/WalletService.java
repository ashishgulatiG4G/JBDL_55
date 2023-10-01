package com.example.service;

import com.example.models.Wallet;
import com.example.repository.WalletRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

//    @Autowired
//    KafkaTemplate<>

    @Autowired
    WalletRepository walletRepository;

    private static final String USER_CREATE_TOPIC = "user_created";

    @Value("${wallet.initial.balance}")
    private Long INITIAL_BALANCE;


    /**
     * Consumer for User Onboarding flow
     */
    @KafkaListener(topics = {USER_CREATE_TOPIC}, groupId = "jbdl1")
    public void createWallet(String msg) throws ParseException {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(msg);

        String phoneNumber = (String) jsonObject.get("phone");

        Wallet wallet = Wallet.builder()
                .balance(INITIAL_BALANCE)
                .currency("INR")
                .walletId(phoneNumber)
                .build();

        walletRepository.save(wallet);

        // TODO -> Publish an event with topic = WALLET_CREATED

    }


}
