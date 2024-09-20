package com.example.pharmapal.entities.mappers;

import com.example.pharmapal.entities.DTOs.ProductsDTO;
import com.example.pharmapal.entities.Products;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(ProductsDTO productsDTO, Products products){
        modelMapper.map(products, productsDTO);
    }
}
