package com.codegym.smartphonemanagament.service;

import com.codegym.smartphonemanagament.entity.Smartphone;
import com.codegym.smartphonemanagament.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return this.smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone phone) {
        this.smartphoneRepository.save(phone);
    }

    @Override
    public void remove(Integer id) {
        this.smartphoneRepository.deleteById(id);
    }
}
