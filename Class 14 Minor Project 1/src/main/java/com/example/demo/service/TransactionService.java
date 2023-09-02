package com.example.demo.service;

import com.example.demo.dto.InitiateTransactionRequest;
import com.example.demo.models.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public String initiateTransaction(InitiateTransactionRequest initiateTransactionRequest) {
        return initiateTransactionRequest.getTransactionType() == TransactionType.RETURN
                ? returnBook(initiateTransactionRequest)
                : issueBook(initiateTransactionRequest);

    }

    private String issueBook(InitiateTransactionRequest initiateTransactionRequest) {
        return "";
    }

    private String returnBook(InitiateTransactionRequest initiateTransactionRequest) {
        return "";
    }



}
