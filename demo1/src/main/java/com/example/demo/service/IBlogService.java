package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void addOrUpdate(Blog blog);
    Blog findById(long id);
    void remove(long id);
}
