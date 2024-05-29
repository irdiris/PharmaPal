package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Products;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;
@Data
public class TherapeuticClassDTO {

        private Long id;

        private String name;

        private String description;

        @OneToMany
        private Set<Products> productsSet;

    }


