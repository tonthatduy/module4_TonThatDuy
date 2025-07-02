package com.example.blogs_ajax.service.blog;

import com.example.blogs_ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    Page<Blog> search(String searchName, Long idCategory, Pageable pageable);
}
