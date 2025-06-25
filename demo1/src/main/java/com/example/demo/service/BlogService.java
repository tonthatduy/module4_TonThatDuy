package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void addOrUpdate(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> search(String searchName, Long idCategory, Pageable pageable) {
        if (idCategory == null || idCategory == 0) {
            return blogRepository.findBlogByTitleContaining(searchName, pageable);
        } else {
            return blogRepository.findBlogByTitleContainingAndCategory_IdCategory(searchName, idCategory, pageable);
        }
    }
}
