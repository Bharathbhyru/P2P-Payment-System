package com.example.PractiseProject.service;

import com.example.PractiseProject.model.User;
import com.example.PractiseProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User findUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
