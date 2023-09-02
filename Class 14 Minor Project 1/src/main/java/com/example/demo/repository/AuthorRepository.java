package com.example.demo.repository;

import com.example.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByEmail(String email);

}
