package com.example.demo.controller;

import com.example.demo.dto.InitiateTransactionRequest;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    /**
     * studentRollNumber
     * bookId
     * adminId
     * transaction Type
     */
    @PostMapping("/transaction")
    public String initiateTransaction(@RequestBody @Valid InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        return transactionService.initiateTransaction(initiateTransactionRequest);
    }


//    @GetMapping("/transaction/payment")
//    public void makePayment(@RequestParam("amount") Integer amount,
//                            @RequestParam("studentId") Integer studentId,
//                            @RequestParam("transactionId") String transactionId) throws Exception {
//
//    }


}
