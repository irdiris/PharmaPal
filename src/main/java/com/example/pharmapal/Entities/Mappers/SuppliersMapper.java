package com.example.pharmapal.Entities.Mappers;
import com.example.pharmapal.Entities.DTOs.SupplierDTO;
import com.example.pharmapal.Entities.Suppliers;
import org.modelmapper.ModelMapper;


import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SuppliersMapper {
    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapSupplierFromDto(SupplierDTO supplierDTO, Suppliers suppliers){
        modelMapper.map(supplierDTO, suppliers);
    }



}
