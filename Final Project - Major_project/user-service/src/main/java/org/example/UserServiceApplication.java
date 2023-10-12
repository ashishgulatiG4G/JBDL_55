package org.example;

import org.example.models.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(User.builder()
//                        .username("txn-service")
//                        .password(new BCryptPasswordEncoder().encode("test123"))
//                        .authorities("svc")
//                .build());
    }
}