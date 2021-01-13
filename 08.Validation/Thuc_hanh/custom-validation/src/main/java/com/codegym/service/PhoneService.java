package com.codegym.service;

import com.codegym.entity.PhoneNumber;

import java.util.List;

public interface PhoneService {
    void save(PhoneNumber phoneNumber);

    List<PhoneNumber> findAll();
}
