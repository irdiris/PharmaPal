package com.example.pharmapal.entities.Mappers;

import com.example.pharmapal.entities.DTOs.ProductFormDTO;
import com.example.pharmapal.entities.ProductForm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductFormMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(ProductFormDTO productFormDTO, ProductForm productForm){
        modelMapper.map(productFormDTO, productForm);
    }
}
