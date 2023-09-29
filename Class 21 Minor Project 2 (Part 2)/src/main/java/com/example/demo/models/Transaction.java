package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String transactionId;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date createdOn;

    private Integer fine;

    @JoinColumn
    @ManyToOne
    private Book book;

    @JoinColumn
    @ManyToOne
    private Student student;

    @JoinColumn
    @ManyToOne
    private Admin admin;

//    public Transaction(final String transactionId, final TransactionType transactionType, final TransactionStatus transactionStatus, final Book book, final Student student, final Admin admin) {
//        this.transactionId = transactionId;
//        this.transactionType = transactionType;
//        this.transactionStatus = transactionStatus;
//        this.book = book;
//        this.student = student;
//        this.admin = admin;
//    }
//
//    public Transaction(final String transactionId, final TransactionType transactionType, final TransactionStatus transactionStatus, final Integer fine, final Book book, final Student student, final Admin admin) {
//        this.transactionId = transactionId;
//        this.transactionType = transactionType;
//        this.transactionStatus = transactionStatus;
//        this.book = book;
//        this.fine = fine;
//        this.student = student;
//        this.admin = admin;
//    }




}
