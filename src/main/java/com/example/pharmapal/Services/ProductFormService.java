package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.ProductFormDTO;
import com.example.pharmapal.Entities.Mappers.ProductFormMapper;
import com.example.pharmapal.Entities.ProductForm;
import com.example.pharmapal.Entities.TherapeuticClass;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormNotFound;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormStillReferencedByProducts;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNotFound;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassStillReferencedByProducts;
import com.example.pharmapal.Interfaces.ProductFormServiceInterface;
import com.example.pharmapal.Repositories.ProductFormRepository;
import com.example.pharmapal.Requests.ProductFormRequest;
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

