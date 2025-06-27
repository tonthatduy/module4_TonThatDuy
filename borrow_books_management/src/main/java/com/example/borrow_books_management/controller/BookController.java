package com.example.borrow_books_management.controller;

import com.example.borrow_books_management.service.IBookService;
import com.example.borrow_books_management.service.IBorrowBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    private IBookService bookService;
    private IBorrowBookService borrowBookService;

    public BookController(IBookService bookService, IBorrowBookService borrowBookService) {
        this.bookService = bookService;
        this.borrowBookService = borrowBookService;
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/view";
    }

    @GetMapping("/borrow")
    public String showBorrowResult() {
        return "book/borrow";
    }

    @PostMapping("/{id}/borrow")
    public String borrowBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            String code = borrowBookService.borrowBook(id);
            redirectAttributes.addFlashAttribute("message", "Mượn sách thành công. Mã mượn: " + code);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/books/borrow";
    }


    @GetMapping("/return")
    public String showReturnPage() {
        return "book/return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long code, RedirectAttributes redirectAttributes) {
        try {
            borrowBookService.returnBook(code);
            redirectAttributes.addFlashAttribute("message", "Trả sách thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error","Trả sách không thành công");
        }
        return "redirect:/books";
    }

}
