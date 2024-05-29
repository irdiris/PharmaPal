package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DTOs.ProductFormDTO;
import com.example.pharmapal.entities.ProductForm;
import com.example.pharmapal.requests.ProductFormRequest;

import java.util.List;

public interface ProductFormServiceInterface {

    List<ProductForm> getProductFroms();
    String addProductForm(ProductForm productForm);

    String UpdateProductForm(ProductFormDTO productFormDTO);


    String deleteProductForm(ProductFormRequest productFormRequest);


}
