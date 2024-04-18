package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.DTOs.ProductsDTO;
import com.example.pharmapal.Entities.Products;
import com.example.pharmapal.Requests.ProductsRequest;

import java.util.List;

public interface ProductsServiceInterface {


    String addProduct(Products product);

    List<Products> getProduct();

    String updateProducts(ProductsDTO productsDTO);

    String deleteProduct(ProductsRequest productsRequest);


    List<Products> getPsychMeds();

    List<Products> getMonitoredMeds();

}
