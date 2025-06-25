package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void addOrUpdate(Category category);
    Category findById(Long id);
    void remove(Long id);

}
