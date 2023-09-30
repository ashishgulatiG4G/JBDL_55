package com.example.demo.dto;

import com.example.demo.models.Book;
import com.example.demo.models.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InitiateTransactionRequest {

    @NotNull
    private String studentRollNumber;

    @NotNull
    private Integer bookId;

    @NotNull
    private TransactionType transactionType;

}
