package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.ProductsDTO;
import com.example.pharmapal.Entities.Mappers.ProductsMapper;
import com.example.pharmapal.Entities.Products;
import com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions.ProductNameIsAlreadyRegisteredException;
import com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions.ProductNotFoundException;
import com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions.ProductStillStockedException;
import com.example.pharmapal.Interfaces.ProductsServiceInterface;
import com.example.pharmapal.Repositories.ProductsRepository;
import com.example.pharmapal.Requests.ProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements ProductsServiceInterface {

    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
@Autowired
    public ProductsService(ProductsRepository productsRepository, ProductsMapper productsMapper) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
    }

    @Override
    public String addProduct(Products product) {
           if(!productsRepository.existsByDesignation(product.getDesignation())){
               productsRepository.save(product);
               return "Product registered";
           }else{
               throw  new ProductNameIsAlreadyRegisteredException("a product with the same name is already registered");
           }
    }

    @Override
    public List<Products> getProduct() {
        return productsRepository.findAll();
    }

    @Override
    public String updateProducts(ProductsDTO productsDTO) {
        Products preUpdateProduct = productsRepository.findById(productsDTO.getId()).orElseThrow(()-> new ProductNotFoundException("this product is not registered"));
        if(!productsRepository.existsByDesignation(productsDTO.getDesignation())){
            productsMapper.mapFromDto(productsDTO, preUpdateProduct);
            productsRepository.save(preUpdateProduct);
            return "product updated successfully";
        }else {
            throw  new ProductNameIsAlreadyRegisteredException("a product with the same name is already registered");
        }
    }

    @Override
    public String deleteProduct(ProductsRequest productsRequest) {
          Products preDeleteProduct =  productsRepository.findById(productsRequest.getId()).orElseThrow(()-> new ProductNotFoundException("this product is not registered"));
          if(preDeleteProduct.getStockedProducts().isEmpty()) {
              productsRepository.delete(preDeleteProduct);
              return "product delete successfully.";
          } else {
              throw new ProductStillStockedException("this product is still in inventory and can't be deleted.");
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
