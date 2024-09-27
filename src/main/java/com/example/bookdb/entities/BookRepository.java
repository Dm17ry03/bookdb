package com.example.bookdb.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // LIST
    public List<Book> listAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    //READ
    public Book getById(Long id) {
        String sql = "select * from books where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    //CREATE inserts book into db and returns num of rows inserted
    public int insertBook(Book book) {
        String sql = "INSERT INTO books (name, author) VALUES (?, ?)";
        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());
    }

    //UPDATE
    public int updateBook(Book book) {
        String sql = "UPDATE books SET name = ?, author = ? WHERE id = ?";
        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getId());
    }

    //DELETE
    public int deleteBook(Long id) {
        String sql = "DELETE FROM books WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }



}
