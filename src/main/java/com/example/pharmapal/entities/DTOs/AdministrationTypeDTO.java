package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Products;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
public class AdministrationTypeDTO {

        private Long id;

        private String form;

        private String description;

        @OneToMany
        private Set<Products> productsSet;
    }

