package com.example.demo.repository;

import com.example.demo.models.SecuredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SecuredUser, Integer> {
    SecuredUser findByUsername(String name);
}
