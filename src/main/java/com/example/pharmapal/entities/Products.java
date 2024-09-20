package com.example.pharmapal.entities;

import com.example.pharmapal.entities.enumerations.Type;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "Products", schema = "PharmaPal")
@Data

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(unique = true)
    private String designation;


    private int totalQuantity;

    private String dci;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "therapeuticClass", referencedColumnName = "tClassId")
    private TherapeuticClass therapeuticClass;

    private String markup;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productForm")

    private ProductForm productForm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrationType")

    private AdministrationType administrationType;

    private String dosage;
    @Enumerated(EnumType.STRING)
    private Type type;

    private String packaging;
    @Column(nullable = false)
    private Boolean isPsychotropic;
    @Column(nullable = false)
    private Boolean isMonitored;

    @OneToMany(mappedBy = "product")
    private Set<StockedProducts> stockedProducts;





}


