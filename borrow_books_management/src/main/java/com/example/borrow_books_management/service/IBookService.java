package com.example.borrow_books_management.service;

import com.example.borrow_books_management.dto.BookDto;
import com.example.borrow_books_management.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);
}
