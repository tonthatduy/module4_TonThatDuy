package com.example.blogs_ajax.repository;

import com.example.blogs_ajax.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

}
