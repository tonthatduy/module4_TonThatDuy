package com.example.borrow_books_management.service;

import com.example.borrow_books_management.model.Book;
import com.example.borrow_books_management.model.BorrowBook;
import com.example.borrow_books_management.repository.IBookRepository;
import com.example.borrow_books_management.repository.IBorrowBookRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BorrowBookService implements IBorrowBookService {
    private IBookRepository bookRepository;
    private IBorrowBookRepository borrowBookRepository;

    public BorrowBookService(IBookRepository bookRepository, IBorrowBookRepository borrowBookRepository) {
        this.bookRepository = bookRepository;
        this.borrowBookRepository = borrowBookRepository;
    }

    @Override
    public String borrowBook(Long idBook) {
        Book book = bookRepository.findById(idBook).orElse(null);
        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Sách đã hết,Không thể mượn");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
        long code;
        do {
            code = 10000 + new Random().nextInt(90000);
        } while (borrowBookRepository.existsByCodeBorrowBook(code));
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setBook(book);
        borrowBook.setCodeBorrowBook(code);
        borrowBookRepository.save(borrowBook);

        return String.valueOf(code);
    }

    @Override
    public void returnBook(Long codeBook) {
        BorrowBook borrowBook = borrowBookRepository.findByCodeBorrowBook(codeBook).orElse(null);
        Book book = borrowBook.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowBookRepository.delete(borrowBook);
    }
}
