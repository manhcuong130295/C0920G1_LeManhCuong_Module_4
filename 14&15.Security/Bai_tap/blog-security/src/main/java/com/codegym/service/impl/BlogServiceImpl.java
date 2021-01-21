package com.codegym.service.impl;

import com.codegym.entity.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByTitleBlogContaining(String keyword, Pageable pageable) {
        return this.blogRepository.findAllByTitleBlogContaining(keyword,pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllAndOrderByWriteDate(Pageable pageable) {
        return this.blogRepository.findAllByOrderByWriteDate(pageable);
    }

}
