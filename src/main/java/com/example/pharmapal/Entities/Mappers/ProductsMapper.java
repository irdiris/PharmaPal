package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.AdministrationType;
import com.example.pharmapal.Entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.Entities.DTOs.ProductsDTO;
import com.example.pharmapal.Entities.Products;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(ProductsDTO productsDTO, Products products){
        modelMapper.map(products, productsDTO);
    }
}
