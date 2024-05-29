package com.example.pharmapal.entities.Mappers;

import com.example.pharmapal.entities.DTOs.LendsDTO;
import com.example.pharmapal.entities.Lends;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LendsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(LendsDTO lendsDTO, Lends lends){
        modelMapper.map(lendsDTO, lends);
    }
}
