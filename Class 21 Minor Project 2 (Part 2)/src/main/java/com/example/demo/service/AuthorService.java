package com.example.demo.service;

import com.example.demo.models.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author getOrCreate(Author author) {
        Author existingAuthor = authorRepository.findByEmail(author.getEmail());
        if (existingAuthor == null) {
            existingAuthor = authorRepository.save(author);
        }
        return existingAuthor;
    }

}
