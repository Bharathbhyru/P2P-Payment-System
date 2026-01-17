package com.example.PractiseProject.controller;


import com.example.PractiseProject.model.PaymentDetails;
import com.example.PractiseProject.model.PaymentStatus;
import com.example.PractiseProject.model.Transaction;
import com.example.PractiseProject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/makePayment")
    public PaymentStatus makePayment(@RequestBody PaymentDetails paymentDetails){
        return paymentService.makeTransaction(paymentDetails);

    }

    @GetMapping("/getTransaction")
    public List<Transaction> getTransactions(@RequestParam Long id){
        return paymentService.getTotalTransactions(id);
    }

    @GetMapping("/getReferenceTransaction")
    public Transaction getReferenceTransaction(@RequestParam String id){
        return paymentService.getTransactionsBasedOnReference(id);
    }



}
