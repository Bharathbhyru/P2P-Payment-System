package com.example.PractiseProject.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String username;
    String passwoord;
    String phoneNo;

    double amount;
    @Column(name = "total_points")
    private Integer totalPoints = 0;

    @Column(name = "is_active")
    private Boolean isActive = true;
    public User() {}

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.passwoord = password;
        this.email = email;
        this.phoneNo = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount =amount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }
}
