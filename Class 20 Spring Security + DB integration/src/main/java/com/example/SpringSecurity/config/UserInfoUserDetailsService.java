package com.example.SpringSecurity.config;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findUserByName(username);
        return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("Username not found in the system"));
    }
}
