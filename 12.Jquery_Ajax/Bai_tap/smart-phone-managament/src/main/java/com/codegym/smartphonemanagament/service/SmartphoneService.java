package com.codegym.smartphonemanagament.service;

import com.codegym.smartphonemanagament.entity.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    void save(Smartphone phone);
    void remove(Integer id);
}
