package com.example.PractiseProject.repository;

import com.example.PractiseProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepo extends JpaRepository<User,Long> {


    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

}
