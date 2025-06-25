package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findBlogByTitleContaining(String title, Pageable pageable);

    Page<Blog> findBlogByTitleContainingAndCategory_IdCategory(String title, Long idCategory, Pageable pageable);

    boolean existsBlogByIdBlog(Long idBlog);
}
