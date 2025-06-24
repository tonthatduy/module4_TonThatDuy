package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.service.IBlogService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private IBlogService blogService;
    private IUserService userService;

    public BlogController(IBlogService blogService, IUserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }

    @ModelAttribute("userList")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("blogList", blogService.findAll());
//        model.addAttribute("userList", userService.findAll());
        return "blog/index";
    }

    @GetMapping("/add")
    public String showFromAdd(Model model) {
        model.addAttribute("blogs", new Blog());
//        model.addAttribute("userList", userService.findAll());
        return "blog/add";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.addOrUpdate(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
//        model.addAttribute("userList", userService.findAll());
        return "blog/update";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("success", "Xóa Thành Công");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }


}
