package com.example.blogs.service;

import com.example.blogs.model.Blog;
import com.example.blogs.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog addOrUpdate(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(long id) {
        return blogRepository.findById(id);
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
