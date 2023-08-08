package com.example.springstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStarterApplication {

    public static void main(String[] args) {
        System.out.println("Starting application");
        SpringApplication.run(SpringStarterApplication.class, args);
    }

}
