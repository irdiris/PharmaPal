package com.example.pharmapal.services;

import com.example.pharmapal.entities.DTOs.ProductFormDTO;
import com.example.pharmapal.entities.Mappers.ProductFormMapper;
import com.example.pharmapal.entities.ProductForm;
import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormDescriptionAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormNameAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormNotFound;
import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormStillReferencedByProducts;
import com.example.pharmapal.interfaces.ProductFormServiceInterface;
import com.example.pharmapal.repositories.ProductFormRepository;
import com.example.pharmapal.requests.ProductFormRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductFormService implements ProductFormServiceInterface {
    private final ProductFormRepository productFormRepository;

    private final ProductFormMapper productFormMapper;
@Autowired
    public ProductFormService(ProductFormRepository productFormRepository, ProductFormMapper productFormMapper) {
        this.productFormRepository = productFormRepository;
    this.productFormMapper = productFormMapper;
}

    @Override
    public List<ProductForm> getProductFroms() {
        return productFormRepository.findAll();
    }

    @Override
    public String addProductForm(ProductForm productForm) {
        if (!productFormRepository.existsByForm(productForm.getForm())) {
            if (!productFormRepository.existsByDescription(productForm.getDescription())) {
                productFormRepository.save(productForm);
                return "new form registered.";
            } else {
                throw new ProductFormNameAlreadyRegistered("this class is already registered.");
            }
        } else {
            throw new ProductFormDescriptionAlreadyRegistered("this description matches another one that is already registered");
        }
    }

    @Override
    public String UpdateProductForm(ProductFormDTO productFormDTO) {
        ProductForm preUpdateProductForm = productFormRepository.findById(productFormDTO.getId()).orElseThrow(() -> new ProductFormNotFound("this class is not registered."));
        if (!productFormRepository.existsByForm(preUpdateProductForm.getForm())) {
            if (!productFormRepository.existsByDescription(preUpdateProductForm.getDescription())) {
                productFormMapper.mapFromDto(productFormDTO, preUpdateProductForm);
               productFormRepository.save(preUpdateProductForm);
                return "new class registered.";
            } else {
                throw new ProductFormNameAlreadyRegistered("this class is already registered.");
            }
        } else {
            throw new ProductFormDescriptionAlreadyRegistered("this description matches another one that is already registered");
        }  }

    @Override
    public String deleteProductForm(ProductFormRequest productFormRequest) {
       ProductForm preDeleteProductForm= productFormRepository.findById(productFormRequest.getId()).orElseThrow(() -> new ProductFormNotFound("this class is not registered."));
        if (preDeleteProductForm.getProductsSet().isEmpty()) {
            productFormRepository.delete(preDeleteProductForm);
            return "Class deleted.";
        } else {
            throw new ProductFormStillReferencedByProducts("there are products that still reference this class, delete them or update the reference.");
        }
    }
    }

