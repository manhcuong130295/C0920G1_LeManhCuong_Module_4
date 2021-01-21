package com.codegym.service;
import com.codegym.entity.Province;


import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    void save(Province province);

    Province findById(int id);

    void update(Province province);

    void remove(int id);
}
