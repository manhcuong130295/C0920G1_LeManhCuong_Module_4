package com.codegym.service.impl;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) throws Exception {

        return this.customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) throws Exception {
        Customer customer = this.customerRepository.findById(id).get();
        if (customer == null) {
            throw new Exception("Customer not found!");
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByNameContaining(String keyword, Pageable pageable) {
        return this.customerRepository.findByNameContaining(keyword, pageable);
    }
}
