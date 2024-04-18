package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.DTOs.LendsDTO;
import com.example.pharmapal.Entities.DTOs.ProductFormDTO;
import com.example.pharmapal.Entities.Lends;
import com.example.pharmapal.Entities.ProductForm;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LendsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(LendsDTO lendsDTO, Lends lends){
        modelMapper.map(lendsDTO, lends);
    }
}
