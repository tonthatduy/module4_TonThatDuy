package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findBlogByTitleContaining(String title, Pageable pageable);

    Page<Blog> findBlogByTitleContainingAndCategory_IdCategory(String title, Long idCategory, Pageable pageable);

    boolean existsBlogByIdBlog(Long idBlog);
}
