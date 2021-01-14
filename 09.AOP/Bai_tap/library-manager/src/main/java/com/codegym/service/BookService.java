package com.codegym.service;

import com.codegym.entity.Books;

import java.util.List;

public interface BookService {
    List<Books> findAll();
    void save(Books books);
    Books findById(int id);
    Books updateAmountBook(String action, Books bookObj) throws Exception;
}
