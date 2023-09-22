package com.example.SpringSecurity.service.impl;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.repository.UserRepo;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepo.findUserByName(name);
    }

    @Override
    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user1 = userRepo.save(user);
        if (user1 != null && user1.getName() != "") {
            return "The user was saved successfully";
        }
        return "Please try again, the user couldn't be saved";
    }
}
