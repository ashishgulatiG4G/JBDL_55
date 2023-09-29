package com.example.demo.controller;

import com.example.demo.dto.CreateBookRequest;
import com.example.demo.dto.SearchRequest;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    // Adding a book

    /**
     * Book ---> Author -> map book to the author
     */

    @Autowired
    BookService bookService;

    //Creation of a book
    // Restricted to ADMIN
    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('CREATE_BOOK')")
    public void createBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        bookService.createOrUpdateBook(createBookRequest.toBook());
    }

    //Getting a list of Books
    @GetMapping("/getBook")

    public List<Book> getBooks(@RequestBody @Valid SearchRequest searchRequest) throws Exception {
        List<Book> list = bookService.findBook(searchRequest.getSearchKey(), searchRequest.getSearchValue());
        return list;
    }


// authorName = Robert, genre = NULL,
// genre = PROGRAMMING, authorName = NULL

//    key = authorName, value = Robert
//    key = genre, value = PROGRAMMING

}
