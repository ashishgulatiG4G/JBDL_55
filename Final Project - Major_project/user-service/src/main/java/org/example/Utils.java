package org.example;

import org.example.dto.CreateUserRequest;
import org.example.dto.GetUserResponse;
import org.example.models.User;

public class Utils {

    public static User convertUserCreateRequest(CreateUserRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .username(request.getUsername())
                .age(request.getAge())
                .password(request.getPassword())
                .build();
    }

    public static GetUserResponse convertToUserResponse(User user){
        return GetUserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .age(user.getAge())
                .email(user.getEmail())
                .updatedOn(user.getUpdatedOn())
                .createdOn(user.getCreatedOn())
                .build();
    }
}
