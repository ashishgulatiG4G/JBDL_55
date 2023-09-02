package com.example.demo.controller;

import com.example.demo.dto.InitiateTransactionRequest;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    /**
     * studentId
     * bookId
     * adminId
     * transaction Type
     */
    public String initiateTransaction(@RequestBody @Valid InitiateTransactionRequest initiateTransactionRequest) {

        return transactionService.initiateTransaction(initiateTransactionRequest);



    }


}
