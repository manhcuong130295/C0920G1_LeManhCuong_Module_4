package com.codegym.service;

import com.codegym.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
