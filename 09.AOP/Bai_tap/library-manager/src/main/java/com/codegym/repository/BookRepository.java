package com.codegym.repository;

import com.codegym.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books,Integer> {
}
