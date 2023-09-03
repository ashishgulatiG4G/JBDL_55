package com.example.demo.repository;

import com.example.demo.models.Student;
import com.example.demo.models.Book;
import com.example.demo.models.Transaction;
import com.example.demo.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    // TODO - verify with List<Transaction>
    Transaction findTransactionByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);

}
