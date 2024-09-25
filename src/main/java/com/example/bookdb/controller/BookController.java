package com.example.bookdb.controller;

import com.example.bookdb.entities.Book;
import com.example.bookdb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.listAll();
    }

    @PostMapping
    public Book getBookById(@RequestBody Long id) {
        return bookService.getById(id);
    }
}
