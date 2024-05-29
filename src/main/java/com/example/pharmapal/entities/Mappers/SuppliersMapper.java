package com.example.pharmapal.entities.Mappers;
import com.example.pharmapal.entities.DTOs.SupplierDTO;
import com.example.pharmapal.entities.Suppliers;
import org.modelmapper.ModelMapper;


import org.springframework.stereotype.Service;



@Service
public class SuppliersMapper {
    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapSupplierFromDto(SupplierDTO supplierDTO, Suppliers suppliers){
        modelMapper.map(supplierDTO, suppliers);
    }



}
