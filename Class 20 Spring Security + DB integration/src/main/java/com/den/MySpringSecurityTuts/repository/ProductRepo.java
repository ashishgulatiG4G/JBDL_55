package com.den.MySpringSecurityTuts.repository;

import com.den.MySpringSecurityTuts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer>{
    Optional<Product> findProductByName(String name);
}
