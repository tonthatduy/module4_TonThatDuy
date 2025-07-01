package com.example.blogs.controller;

import com.example.blogs.model.Blog;
import com.example.blogs.model.Category;
import com.example.blogs.model.User;
import com.example.blogs.service.IBlogService;
import com.example.blogs.service.ICategoryService;
import com.example.blogs.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
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

    @GetMapping()
    public ResponseEntity<Page<Blog>> getAllBlogs(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size,
                                                  @RequestParam(defaultValue = "") String searchName,
                                                  @RequestParam(required = false) Long idCategory,
                                                  @RequestParam(defaultValue = "false") boolean sortDate) {
        Sort sort;
        if (sortDate) {
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        } else
            sort = Sort.by(Sort.Direction.ASC, "createdAt");
        Pageable pageable = PageRequest.of(page, size, sort);
        Long categoryFilter = (idCategory != null && idCategory != 0) ? idCategory : null;
        Page<Blog> blogPage = blogService.search(searchName, categoryFilter, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204 nếu không có dữ liệu
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK); //200 + dữ liệu
    }

    @GetMapping("/{id}/categories")
    public ResponseEntity<Page<Blog>> getBlogByCategory(@PathVariable Long id,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "3") int size,
                                                        @RequestParam(defaultValue = "false") boolean sortDate) {
        Sort sort;
        if (sortDate) {
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        } else
            sort = Sort.by(Sort.Direction.ASC, "createdAt");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> blogPage = blogService.search("", id, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.addOrUpdate(blog), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setIdBlog(blogOptional.get().getIdBlog());
        return new ResponseEntity<>(blogService.addOrUpdate(blog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
