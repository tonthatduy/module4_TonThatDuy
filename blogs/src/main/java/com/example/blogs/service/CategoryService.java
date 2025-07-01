package com.example.blogs.service;

import com.example.blogs.model.Category;
import com.example.blogs.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addOrUpdate(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        if (categoryRepository.existsById(id)) {
            throw new IllegalArgumentException();
        } else {
            categoryRepository.deleteById(id);
        }
    }
}
