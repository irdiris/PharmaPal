package com.example.pharmapal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "ProductForm")
public class ProductForm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String form;

    private String description;

    @OneToMany(mappedBy = "productForm")
    private Set<Products> productsSet;

}
