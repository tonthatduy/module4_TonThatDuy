package com.example.borrow_books_management.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private int visitCount = 0;

    @Before("execution(* com.example.borrow_books_management.controller.BookController.showList(..))")
    public void countVisit(JoinPoint joinPoint) {
        visitCount++;
        System.out.println("[VISIT] Tổng số lượt truy cập hệ thống: " + visitCount);
    }

    @AfterReturning("execution(* com.example.borrow_books_management.service.BorrowBookService.borrowBook(..))")
    public void logBorrow() {
        System.out.println("[LOG] Đã thực hiện mượn sách.");
    }

    @AfterReturning("execution(* com.example.borrow_books_management.service.BorrowBookService.returnBook(..))")
    public void logReturn() {
        System.out.println("[LOG] Đã thực hiện trả sách.");
    }
}
