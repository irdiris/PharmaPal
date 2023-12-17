package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity
@Data
@Table(schema = "PharmaPal", name = "AdministrationType")
public class AdministrationType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String form;

    private String description;

    @OneToMany
    private Set<Products> productsSet;
}
