package com.codegym.repository;

import com.codegym.entity.LibCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibCard,Integer> {
}
