package com.codegym.service.impl;

import com.codegym.entity.LibCard;
import com.codegym.repository.CardRepository;
import com.codegym.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public List<LibCard> findAll() {
        return cardRepository.findAll();
    }
}
