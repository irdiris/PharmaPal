package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Products;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
