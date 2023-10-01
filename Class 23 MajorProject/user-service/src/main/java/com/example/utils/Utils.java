package com.example.utils;

import com.example.dto.CreateUserRequest;
import com.example.dto.GetUserResponse;
import com.example.models.User;

public class Utils {

    // dto -> model
    public static User convertUserCreateRequestToUser(CreateUserRequest createUserRequest) {
        return User.builder()
                .name(createUserRequest.getName())
                .age(createUserRequest.getAge())
                .email(createUserRequest.getEmail())
                .phone(createUserRequest.getPhone())
                .build();
    }

    //model -> dto
    public static GetUserResponse convertUserToGetUserResponse(User user) {
        return GetUserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .phone(user.getPhone())
                .email(user.getEmail())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();
    }

}
