package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.DTOs.ProductFormDTO;
import com.example.pharmapal.Entities.ProductForm;
import com.example.pharmapal.Requests.ProductFormRequest;

import java.util.List;

public interface ProductFormServiceInterface {

    List<ProductForm> getProductFroms();
    String addProductForm(ProductForm productForm);

    String UpdateProductForm(ProductFormDTO productFormDTO);


    String deleteProductForm(ProductFormRequest productFormRequest);


}
