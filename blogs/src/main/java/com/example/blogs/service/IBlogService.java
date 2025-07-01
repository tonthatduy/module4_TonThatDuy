package com.example.blogs.service;

import com.example.blogs.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Blog addOrUpdate(Blog blog);

    Optional<Blog> findById(long id);

    void remove(long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> search(String searchName, Long idCategory, Pageable pageable);
}
