package com.codegym.service;

import com.codegym.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BillService {
    String getToDay();
    void saveBill(Bill bill);
    Page<Bill> findAll(Pageable pageable);
    void remove(int id);
    Bill findById(int id);

}
