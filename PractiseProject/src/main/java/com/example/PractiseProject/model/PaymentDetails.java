package com.example.PractiseProject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
    Long senderId;
    Long recipientId;
    double amount;
    String notes;
    TransactionCategory Category;

    public Long getRecipientId() {
        return recipientId;
    }

//    public Long getId() {
//        return id;
//    }

    public Long getSenderId() {
        return senderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getNotes() {
        return notes;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public TransactionCategory getCategory() {
        return Category;
    }

    public void setCategory(TransactionCategory category) {
        Category = category;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
