package com.example.pharmapal.entities.mappers;

import com.example.pharmapal.entities.DTOs.ShiftsDTO;
import com.example.pharmapal.entities.Shifts;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShiftsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(ShiftsDTO shiftsDTO, Shifts shifts){
        modelMapper.map(shiftsDTO, shifts);
    }
}
