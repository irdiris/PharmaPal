package com.example.pharmapal.services;

import com.example.pharmapal.entities.DTOs.ProductsDTO;
import com.example.pharmapal.entities.mappers.ProductsMapper;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions.ProductNameIsAlreadyRegisteredException;
import com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions.ProductNotFoundException;
import com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions.ProductStillStockedException;
import com.example.pharmapal.interfaces.ProductsServiceInterface;
import com.example.pharmapal.repositories.ProductsRepository;
import com.example.pharmapal.repositories.StockedProductsRepository;
import com.example.pharmapal.requests.ProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsService implements ProductsServiceInterface {

    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
    private final StockedProductsRepository stockedProductsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository, ProductsMapper productsMapper, StockedProductsRepository stockedProductsRepository) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
        this.stockedProductsRepository = stockedProductsRepository;
    }



    @Override
    public String addProduct(Products product) {
        if (!productsRepository.existsByDesignation(product.getDesignation())) {
            productsRepository.save(product);
            return "Product registered";
        } else {
            throw new ProductNameIsAlreadyRegisteredException("A product with the same name is already registered");
        }
    }

    @Override
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    @Transactional
    public Products getProduct(Long id) {
        return productsRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("This product does not exist"));
    }

    @Override
    public String updateProducts(ProductsDTO productsDTO) {
        Products preUpdateProduct = productsRepository.findById(productsDTO.getId())
                .orElseThrow(() -> new ProductNotFoundException("This product is not registered"));
        if (!productsRepository.existsByDesignation(productsDTO.getDesignation())) {
            productsMapper.mapFromDto(productsDTO, preUpdateProduct);
            productsRepository.save(preUpdateProduct);
            return "Product updated successfully";
        } else {
            throw new ProductNameIsAlreadyRegisteredException("A product with the same name is already registered");
        }
    }

    @Override
    public String deleteProduct(ProductsRequest productsRequest) {
        Products preDeleteProduct = productsRepository.findById(productsRequest.getId())
                .orElseThrow(() -> new ProductNotFoundException("This product is not registered"));
        if (preDeleteProduct.getStockedProducts().isEmpty()) {
            productsRepository.delete(preDeleteProduct);
            return "Product deleted successfully.";
        } else {
            throw new ProductStillStockedException("This product is still in inventory and can't be deleted.");
        }
    }

    @Override
    public List<Products> getPsychMeds() {
        return productsRepository.findAllByIsPsychotropicIsTrue();
    }

    @Override
    public List<Products> getMonitoredMeds() {
        return productsRepository.findAllByIsMonitoredIsTrue();
    }
}
