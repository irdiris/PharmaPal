package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.DTOs.ShiftsDTO;
import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.Staff;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShiftsMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(ShiftsDTO shiftsDTO, Shifts shifts){
        modelMapper.map(shiftsDTO, shifts);
    }
}
