package com.example.pharmapal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table( name = "Suppliers")
@Entity
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private double phone;
    private double fax;
    private String website;
    private String address;
    private String email;
    private String state;
    private double RC; // Registre de commerce
    private double NIF; // numero identification fiscal
    private double NAI; // numero articles d'imposition
    private double NIS; // numero identification static
    private double RIB; // compte bancaire

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Bills> bills;
}
