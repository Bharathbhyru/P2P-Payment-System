package com.example.PractiseProject.repository;

import com.example.PractiseProject.model.Transaction;
import com.example.PractiseProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface TransactionEntity extends JpaRepository<Transaction,Long> {



    List<Transaction> findByUserOrderByCreatedAtDesc(User user);

    @Query("SELECT t FROM Transaction t WHERE t.transactionReference = :id")
    Transaction getTransactionBasedOnReference(String id);
}
