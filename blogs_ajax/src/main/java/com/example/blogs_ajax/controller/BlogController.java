package com.example.blogs_ajax.controller;

import com.example.blogs_ajax.model.Blog;
import com.example.blogs_ajax.model.Category;
import com.example.blogs_ajax.service.blog.IBlogService;
import com.example.blogs_ajax.service.category.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogController {
    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("categoryList")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Blog>> listBlog() {
//        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<Page<Blog>> getAllBlogs(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "title").and(Sort.by(Sort.Direction.DESC, "createAt"));
        Pageable pageable = PageRequest.of(page, size, sort);
//        Long categoryFilter = (idCategory != null && idCategory != 0) ? idCategory : null;
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);

    }
}
