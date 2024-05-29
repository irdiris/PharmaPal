package com.example.pharmapal.entities.Mappers;

import com.example.pharmapal.entities.AdministrationType;
import com.example.pharmapal.entities.DTOs.AdministrationTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AdministrationTypeMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(AdministrationTypeDTO administrationTypeDTO, AdministrationType administrationType){
        modelMapper.map(administrationTypeDTO, administrationType);
    }
}
