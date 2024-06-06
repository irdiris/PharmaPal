package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(schema = "pharma_pal" ,name = "Suppliers")
@Entity
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
