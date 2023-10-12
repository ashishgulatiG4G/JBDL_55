package org.example.repository;

import org.example.models.Transaction;
import org.example.models.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Transactional
    @Modifying
    @Query("update Transaction t set t.transactionStatus = ?2 where t.externalId = ?1")
    void updateTransaction(String externalTxnId, TransactionStatus transactionStatus);
}
