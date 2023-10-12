package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Utils;
import org.example.dto.CreateUserRequest;
import org.example.dto.GetUserResponse;
import org.example.models.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /** Sign-up api */
    @PostMapping("/user")
    public void createUser(@RequestBody @Valid CreateUserRequest userRequest) throws JsonProcessingException {
        userService.create(Utils.convertUserCreateRequest(userRequest));
    }


    /** To be used by a user for getting its profile details */
    @GetMapping("/user/get")
    public GetUserResponse getUser() throws Exception {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        user = userService.get(user.getId());
        return Utils.convertToUserResponse(user);
    }

    /** To be used by other services for authentication */
    @GetMapping(value = "/user/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByUsername(@PathVariable("username") String username) {
        User user = (User) userService.loadUserByUsername(username);
        return user;
    }
}
