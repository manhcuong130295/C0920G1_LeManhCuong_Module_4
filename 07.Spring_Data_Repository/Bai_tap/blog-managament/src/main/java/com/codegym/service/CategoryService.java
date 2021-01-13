package com.codegym.service;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);

}
