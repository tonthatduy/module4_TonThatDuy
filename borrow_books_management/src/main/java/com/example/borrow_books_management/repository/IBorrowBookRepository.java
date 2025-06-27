package com.example.borrow_books_management.repository;

import com.example.borrow_books_management.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Long> {
    boolean existsByCodeBorrowBook(long code);

    Optional<BorrowBook> findByCodeBorrowBook(Long codeBorrowBook);
}
