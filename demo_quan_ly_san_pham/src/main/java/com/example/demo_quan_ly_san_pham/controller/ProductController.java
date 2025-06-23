package com.example.demo_quan_ly_san_pham.controller;


import com.example.demo_quan_ly_san_pham.model.Product;
import com.example.demo_quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Product> productList = productService.searchByName(keyword);
        model.addAttribute("products", productList);
        return "/index";
    }
}
