package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.Enumerations.LendStates;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.entities.ProductsSold;
import com.example.pharmapal.entities.PsychotropicDrugSales;
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
