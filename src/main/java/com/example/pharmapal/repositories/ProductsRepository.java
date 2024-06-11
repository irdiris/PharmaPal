package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.Lends;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.entities.TherapeuticClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    boolean existsByDesignation(String designation);

    List<Products> findAllByIsMonitoredIsTrue();

    List<Products> findAllByIsPsychotropicIsTrue();
    Set<Products> findAllByTherapeuticClass(TherapeuticClass therapeuticClass);

}
