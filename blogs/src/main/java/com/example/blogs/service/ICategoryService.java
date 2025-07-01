package com.example.blogs.service;

import com.example.blogs.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Category addOrUpdate(Category category);
    Optional<Category> findById(Long id);
    void remove(Long id);

}
