package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.Entities.DTOs.SupplierDTO;
import com.example.pharmapal.Entities.StockedProducts;
import com.example.pharmapal.Entities.Suppliers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StockedProductsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapStockedProductsFromDto(StockedProductsDTO stockedProductsDTO, StockedProducts stockedProducts){
        modelMapper.map(stockedProductsDTO, stockedProducts);
    }
}
