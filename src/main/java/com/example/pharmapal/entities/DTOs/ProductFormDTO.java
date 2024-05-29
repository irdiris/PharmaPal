package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Products;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductFormDTO {

    private Long id;

    private String form;

    private String description;

    @OneToMany
    private Set<Products> productsSet;
}
