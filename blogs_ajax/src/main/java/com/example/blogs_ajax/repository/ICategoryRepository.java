package com.example.blogs_ajax.repository;

import com.example.blogs_ajax.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
