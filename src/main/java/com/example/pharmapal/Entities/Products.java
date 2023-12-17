package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "Products", schema = "PharmaPal")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String designation;

    @Column(unique = true)
    private String dci;

    @ManyToOne
    @JoinColumn(name = "therapeuticClass")
    private TherapeuticClass therapeuticClass;

    private String markup;
    @ManyToOne
    @JoinColumn(name = "productForm")
    private ProductForm productForm;

    @ManyToOne
    @JoinColumn(name = "administrationType")
    private AdministrationType administrationType;

    private String dosage;

    private String packaging;

    private Boolean isPsychotropic;

    private Boolean isMonitored;

@OneToMany(mappedBy = "product")
    private Set<StockedProducts> stockedProducts;

@OneToMany(mappedBy = "products")
    private Set<Lends> lends;



}


