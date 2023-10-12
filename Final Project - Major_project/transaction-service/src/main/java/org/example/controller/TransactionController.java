package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.TransactionCreateRequest;
import org.example.models.User;
import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    /** Transaction api */
    @PostMapping("/transaction")
    public String transact(@RequestBody @Valid TransactionCreateRequest request) throws JsonProcessingException {
        User sender = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return transactionService.transact(request, sender.getUsername());
    }
}
