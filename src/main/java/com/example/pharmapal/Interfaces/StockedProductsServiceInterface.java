package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.Entities.StockedProducts;
import com.example.pharmapal.Requests.StockedProductsRequest;

import java.util.List;

public interface StockedProductsServiceInterface {

    public List<StockedProducts> getStockedProducts();

    public String stockProducts(StockedProducts stockedProducts);

    public String updateStockedProduct(StockedProductsDTO stockedProductsDTO);

    public String deleteStockedProduct(StockedProductsRequest stockedProductsRequest);
    
}
