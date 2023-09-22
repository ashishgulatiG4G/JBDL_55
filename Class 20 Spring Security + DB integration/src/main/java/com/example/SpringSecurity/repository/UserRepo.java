package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByName(String name);
}
