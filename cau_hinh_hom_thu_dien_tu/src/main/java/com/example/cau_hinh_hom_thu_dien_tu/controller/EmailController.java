package com.example.cau_hinh_hom_thu_dien_tu.controller;

import com.example.cau_hinh_hom_thu_dien_tu.model.Email;
import com.example.cau_hinh_hom_thu_dien_tu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        Email email = emailService.findById(id);
        model.addAttribute("email", email);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 25, 50, 100});
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Email email) {
        Email email1 = emailService.findById(email.getId());
        if (email1 != null) {
            email1.setLanguage(email.getLanguage());
            email1.setPageSize(email.getPageSize());
            email1.setSpamFiler(email.getSpamFiler());
            email1.setSignature(email.getSignature());
        }
        return "redirect:/list";

    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Email> emailList = emailService.findAll();
        model.addAttribute("emailList", emailList);
        return "/list";
    }
}
