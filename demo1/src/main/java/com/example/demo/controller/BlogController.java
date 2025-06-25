package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private IBlogService blogService;
    private IUserService userService;
    private ICategoryService categoryService;

    public BlogController(IBlogService blogService, IUserService userService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("userList")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @ModelAttribute("categoryList")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @ModelAttribute("sizeList")
    public List<Integer> getAllSizeList() {
        return Arrays.asList(3, 5, 7, 9, 11);
    }

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "3") int size,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(required = false) Long idCategory,
                           @RequestParam(required = false, defaultValue = "false") boolean sortDate,
                           Model model) {
        Sort sort;
        if (sortDate) {
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        } else
            sort = Sort.by(Sort.Direction.ASC, "createdAt");
        Pageable pageable = PageRequest.of(page, size, sort);
        Long categoryFilter = (idCategory != null && idCategory != 0) ? idCategory : null;
        Page<Blog> blogPage = blogService.search(searchName, categoryFilter, pageable);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchCategory", idCategory);
        model.addAttribute("blogList", blogPage);
        model.addAttribute("size", size);
        model.addAttribute("createdAt", sortDate);
        return "blog/index";
    }

    @GetMapping("/add")
    public String showFromAdd(Model model) {
        model.addAttribute("blogs", new Blog());
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
