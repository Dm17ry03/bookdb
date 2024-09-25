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

    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    public int insertBook(Book book) {
        return bookRepository.insertBook(book);
    }

}
