package com.codegym.service;

import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog> findAllByTitleBlogContaining(String keyword, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllAndOrderByWriteDate(Pageable pageable);
}
