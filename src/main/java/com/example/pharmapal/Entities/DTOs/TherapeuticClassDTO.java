package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Products;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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


