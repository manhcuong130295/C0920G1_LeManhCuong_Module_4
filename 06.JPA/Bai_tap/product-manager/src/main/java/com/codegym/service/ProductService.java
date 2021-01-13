package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save (Product product);
    void delete(String id);
    Product findById(String id);
    List<Product> findByName(String name);
}
