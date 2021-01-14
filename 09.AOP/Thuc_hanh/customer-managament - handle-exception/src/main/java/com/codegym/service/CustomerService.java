package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable) throws Exception;

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id) throws Exception;

    void update(Customer customer);

    void remove(int id);

    Page<Customer> findByNameContaining(String keyword, Pageable pageable);
}
