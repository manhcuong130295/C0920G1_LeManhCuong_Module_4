package com.codegym.smartphonemanagament.repository;

import com.codegym.smartphonemanagament.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {

}
