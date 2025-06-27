package com.example.borrow_books_management.service;

public interface IBorrowBookService {
    String borrowBook(Long idBook);
    void returnBook(Long codeBook);

}
