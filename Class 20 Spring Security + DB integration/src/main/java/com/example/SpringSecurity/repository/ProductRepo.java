package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer>{
    Optional<Product> findProductByName(String name);
}
