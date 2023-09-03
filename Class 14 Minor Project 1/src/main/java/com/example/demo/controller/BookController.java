package com.example.demo.controller;

import com.example.demo.dto.CreateBookRequest;
import com.example.demo.dto.SearchRequest;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    // Adding a book

    /**
     * Book ---> Author -> map book to the author
     */

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        bookService.createOrUpdateBook(createBookRequest.toBook());
    }

    //Getting a list of Books
    @GetMapping("/getBooks")
    public List<Book> getBooks(@RequestBody @Valid SearchRequest searchRequest) throws Exception {
        List<Book> list = bookService.findBook(searchRequest.getSearchKey(), searchRequest.getSearchValue());
        return list;
    }


// authorName = Robert, genre = NULL,
// genre = PROGRAMMING, authorName = NULL

//    key = authorName, value = Robert
//    key = genre, value = PROGRAMMING

}
