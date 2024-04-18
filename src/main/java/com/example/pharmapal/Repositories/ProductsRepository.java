package com.example.pharmapal.Repositories;

import com.example.pharmapal.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    boolean existsByDesignation(String designation);

    List<Products> findAllByIsMonitoredIsTrue();

    List<Products> findAllByIsPsychotropicIsTrue();
}
