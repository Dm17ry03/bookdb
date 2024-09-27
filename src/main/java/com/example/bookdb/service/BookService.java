package com.example.bookdb.service;

import com.example.bookdb.entities.Book;
import com.example.bookdb.entities.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //LIST
    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    //READ
    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    //CREATE
    public int insertBook(Book book) {
        return bookRepository.insertBook(book);
    }

    //UPDATE
    public int updateBook(Book book) {
        return bookRepository.updateBook(book);
    }

    //DELETE
    public int deleteBook(Long id) {
        return bookRepository.deleteBook(id);
    }
}
