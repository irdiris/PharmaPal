package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.entities.StockedProducts;
import com.example.pharmapal.requests.StockedProductsRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface StockedProductsServiceInterface {

    public List<StockedProducts> getStockedProducts();

    public String stockProducts(StockedProducts stockedProducts);

    public String updateStockedProduct(StockedProductsDTO stockedProductsDTO);

    public String deleteStockedProduct(StockedProductsRequest stockedProductsRequest);


    Set<StockedProducts> getRelatedStockedProducts(Products products);
    int getNearExpirationProducts();

    int getCloseExpirationProducts();

    List<StockedProducts> getAvailableProducts();
}
