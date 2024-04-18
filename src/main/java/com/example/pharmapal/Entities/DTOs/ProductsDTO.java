package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
public class ProductsDTO {

    private Long id;


    private String designation;


    private String dci;

    private TherapeuticClass therapeuticClass;

    private String markup;

    private ProductForm productForm;


    private AdministrationType administrationType;

    private String dosage;

    private String packaging;

    private Boolean isPsychotropic;

    private Boolean isMonitored;


    private Set<StockedProducts> stockedProducts;


    private Set<Lends> lends;

}
