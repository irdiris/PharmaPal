package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    boolean existsByDesignation(String designation);

    List<Products> findAllByIsMonitoredIsTrue();

    List<Products> findAllByIsPsychotropicIsTrue();
}
