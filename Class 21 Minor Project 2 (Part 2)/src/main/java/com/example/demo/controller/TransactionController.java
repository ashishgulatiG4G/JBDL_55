package com.example.demo.controller;

import com.example.demo.dto.InitiateTransactionRequest;
import com.example.demo.models.SecuredUser;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    /**
     * studentRollNumber
     * bookId
     * adminId
     * transaction Type
     */
    @PostMapping("/initiate")
    public String initiateTransaction(@RequestBody @Valid InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser user = (SecuredUser) authentication.getPrincipal();
        Integer adminId = user.getAdmin().getId();
        return transactionService.initiateTransaction(initiateTransactionRequest, adminId);
    }


//    @GetMapping("/transaction/payment")
//    public void makePayment(@RequestParam("amount") Integer amount,
//                            @RequestParam("studentId") Integer studentId,
//                            @RequestParam("transactionId") String transactionId) throws Exception {
//
//    }


}
