package com.example.pharmapal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity
@Data
@Table(schema = "PharmaPal", name = "AdministrationType")
public class AdministrationType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administration_type_seq")
    private Long id;

    private String form;

    private String description;

    @OneToMany(mappedBy ="administrationType" )
    private Set<Products> productsSet;
}
