package com.codegym.repository.impl;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }
}
