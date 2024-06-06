package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DTOs.ProductsDTO;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.requests.ProductsRequest;

import java.util.List;

public interface ProductsServiceInterface {


    String addProduct(Products product);

    List<Products> getProducts();

    Products getProduct(Long id);

    String updateProducts(ProductsDTO productsDTO);

    String deleteProduct(ProductsRequest productsRequest);


    List<Products> getPsychMeds();

    List<Products> getMonitoredMeds();

}
