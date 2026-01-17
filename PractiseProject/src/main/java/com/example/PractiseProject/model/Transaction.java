package com.example.PractiseProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "related_user_id")
    private User relatedUser;

    @Column(nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status = TransactionStatus.COMPLETED;

    @Column(length = 500)
    private String notes;

    @Enumerated(EnumType.STRING)
    private TransactionCategory category;

    @Column(name = "transaction_reference")
    private String transactionReference;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors
    public Transaction() {}

    public Transaction(User user, User relatedUser, double amount, TransactionType type,
                       String notes, TransactionCategory category, String transactionReference) {
        this.user = user;
        this.relatedUser = relatedUser;
        this.amount = amount;
        this.type = type;
        this.notes = notes;
        this.category = category;
        this.transactionReference = transactionReference;
    }


}
