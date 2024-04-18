package com.example.pharmapal.Repositories;

import com.example.pharmapal.Entities.ProductForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFormRepository extends JpaRepository<ProductForm, Long> {

    boolean existsByForm(String form);
    boolean existsByDescription(String description);
}
