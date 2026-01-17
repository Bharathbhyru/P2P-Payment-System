package com.example.PractiseProject.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PaymentStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String UUId;
    String message;
}
