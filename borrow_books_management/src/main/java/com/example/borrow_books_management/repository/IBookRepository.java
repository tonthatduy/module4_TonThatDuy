package com.example.borrow_books_management.repository;

import com.example.borrow_books_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
