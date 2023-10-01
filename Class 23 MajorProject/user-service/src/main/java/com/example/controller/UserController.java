package com.example.controller;

import com.example.dto.CreateUserRequest;
import com.example.dto.GetUserResponse;
import com.example.models.User;
import com.example.service.UserService;
import com.example.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) throws JsonProcessingException {
        userService.create(Utils.convertUserCreateRequestToUser(createUserRequest));
    }

    @GetMapping("/{userId}")
    public GetUserResponse getUser(@PathVariable("userId") int userId) {
        User user = userService.find(userId);
        return Utils.convertUserToGetUserResponse(user);
    }



}
