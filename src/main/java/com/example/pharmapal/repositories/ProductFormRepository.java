package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.ProductForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFormRepository extends JpaRepository<ProductForm, Long> {

    boolean existsByForm(String form);
    boolean existsByDescription(String description);
}
