package com.codegym.service;

import com.codegym.entity.PhoneNumber;
import com.codegym.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public void save(PhoneNumber phoneNumber) {
        this.phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public List<PhoneNumber> findAll() {
        return this.phoneNumberRepository.findAll();
    }
}
