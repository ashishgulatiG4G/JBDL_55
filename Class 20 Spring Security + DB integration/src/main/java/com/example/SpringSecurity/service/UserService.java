package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserByName(String name);
    String saveUser(User user);
}
