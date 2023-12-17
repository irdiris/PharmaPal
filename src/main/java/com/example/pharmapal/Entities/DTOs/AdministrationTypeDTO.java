package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Products;
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

