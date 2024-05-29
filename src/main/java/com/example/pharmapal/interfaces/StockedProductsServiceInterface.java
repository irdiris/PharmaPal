package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.entities.StockedProducts;
import com.example.pharmapal.requests.StockedProductsRequest;

import java.util.List;

public interface StockedProductsServiceInterface {

    public List<StockedProducts> getStockedProducts();

    public String stockProducts(StockedProducts stockedProducts);

    public String updateStockedProduct(StockedProductsDTO stockedProductsDTO);

    public String deleteStockedProduct(StockedProductsRequest stockedProductsRequest);
    
}
