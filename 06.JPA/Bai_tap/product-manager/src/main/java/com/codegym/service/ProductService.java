package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save (Product product);
    void delete(Integer id);
    Product findById(Integer id);
    List<Product> findByName(String name);
}
