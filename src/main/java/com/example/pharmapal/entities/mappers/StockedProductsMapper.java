package com.example.pharmapal.entities.mappers;

import com.example.pharmapal.entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.entities.StockedProducts;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StockedProductsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapStockedProductsFromDto(StockedProductsDTO stockedProductsDTO, StockedProducts stockedProducts){
        modelMapper.map(stockedProductsDTO, stockedProducts);
    }
}
