package com.example.PractiseProject.service;

import com.example.PractiseProject.model.*;
import com.example.PractiseProject.repository.TransactionEntity;
import com.example.PractiseProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    UserService userService;

    @Autowired
    TransactionEntity transactionEntity;
    @Autowired
    UserRepo userRepo;



  public   PaymentStatus makeTransaction(PaymentDetails paymentDetails){

      String transactionReference = "TXN" + UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();

      User sender = userService.findUserById(paymentDetails.getSenderId());
      User recipient = userService.findUserById(paymentDetails.getRecipientId());


      // Update balances
      double x=sender.getAmount()-paymentDetails.getAmount();
      double y=recipient.getAmount()+paymentDetails.getAmount();
      sender.setAmount(x);
      recipient.setAmount(y);
      System.out.println(x+" "+y);

      // Create debit transaction for sender
      Transaction debitTransaction = new Transaction(
              sender,
              recipient,
              paymentDetails.getAmount(),
              TransactionType.DEBIT,
              paymentDetails.getNotes(),
              paymentDetails.getCategory() != null ? paymentDetails.getCategory() : TransactionCategory.OTHERS,
              transactionReference
      );

      // Create credit transaction for recipient
      Transaction creditTransaction = new Transaction(
              recipient,
              sender,
              paymentDetails.getAmount(),
              TransactionType.CREDIT,
              paymentDetails.getNotes(),
              paymentDetails.getCategory()!= null ? paymentDetails.getCategory() : TransactionCategory.OTHERS,
              transactionReference
      );

      // Save transactions first and flush to surface DB errors early
      transactionEntity.save(debitTransaction);
      transactionEntity.save(creditTransaction);
      transactionEntity.flush();

      // Award points for the transaction
      sender.setTotalPoints(sender.getTotalPoints() + 1);
      recipient.setTotalPoints(recipient.getTotalPoints() + 1);

      // Save users with updated balances and points
      userRepo.save(sender);
      userRepo.save(recipient);
      userRepo.flush();


      return  new PaymentStatus();
    }




    public List<Transaction> getTotalTransactions( Long id){
      List<Transaction> t=new ArrayList<>();

      User current= userService.findUserById(id);

      t=transactionEntity.findByUserOrderByCreatedAtDesc(current);


        return t;
    }

    public Transaction getTransactionsBasedOnReference(String id){
      return transactionEntity.getTransactionBasedOnReference(id);
    }
}
