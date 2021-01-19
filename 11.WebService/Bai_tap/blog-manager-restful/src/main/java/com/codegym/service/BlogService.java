package com.codegym.service;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog> findAllByTitleBlogContaining(String keyword, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllAndOrderByWriteDate(Pageable pageable);
    Page<Blog> findAllByCategory_Id(Integer id,Pageable pageable);
}
