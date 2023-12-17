package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.AdministrationType;
import com.example.pharmapal.Entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.Entities.DTOs.ShiftsDTO;
import com.example.pharmapal.Entities.Shifts;
import org.modelmapper.ModelMapper;

public class AdministrationTypeMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(AdministrationTypeDTO administrationTypeDTO, AdministrationType administrationType){
        modelMapper.map(administrationTypeDTO, administrationType);
    }
}
