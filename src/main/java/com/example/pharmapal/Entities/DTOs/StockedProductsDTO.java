package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Bills;
import com.example.pharmapal.Entities.Enumerations.LendStates;
import com.example.pharmapal.Entities.Products;
import com.example.pharmapal.Entities.ProductsSold;
import com.example.pharmapal.Entities.PsychotropicDrugSales;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StockedProductsDTO {
 
    private String lotNumber;


    private Products product;


    private Bills bills;


    private Integer quantity;


    private LocalDate expirationDate;


    private double unitPrice;


    private double margin;


    private double ppa;

    private double shp;


    private double tv;


    private double tht;

    private LendStates state;


    private Set<ProductsSold> productsSold;


    private Set<PsychotropicDrugSales> psychotropicDrugSales;

}
