package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void addOrUpdate(Blog blog);

    Blog findById(long id);

    void remove(long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> search(String searchName, Long idCategory, Pageable pageable);
}
