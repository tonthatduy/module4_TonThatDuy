package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/index";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/save")
    public String save(Category category) {
        categoryService.addOrUpdate(category);
        return "redirect:/categorys";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("categorys", categoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirect) {
        try {
            categoryService.remove(id);
            redirect.addFlashAttribute("success", "Xóa Thành Công");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            redirect.addFlashAttribute("fail", "Category tồn tại trong Blog");
        }
        return "redirect:/categorys";
    }

}
