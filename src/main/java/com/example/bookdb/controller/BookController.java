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

    //LIST
    @GetMapping
    public List<Book> listBooks() {
        return bookService.listAll();
    }

    //READ
    @GetMapping("getByID")
    public Book getBookById(@RequestBody Long id) {
        return bookService.getById(id);
    }

    //CREATE
    @PostMapping
    public int createBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    //UPDATE
    @PatchMapping
    public int updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    //DELETE
    @DeleteMapping
    public int deleteBookById(@RequestBody Long id) {
        return bookService.deleteBook(id);
    }
}
