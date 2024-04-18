package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.AdministrationType;
import com.example.pharmapal.Entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.Entities.DTOs.ProductFormDTO;
import com.example.pharmapal.Entities.ProductForm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductFormMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(ProductFormDTO productFormDTO, ProductForm productForm){
        modelMapper.map(productFormDTO, productForm);
    }
}
