package com.example.pharmapal.Entities.Mappers;

import com.example.pharmapal.Entities.AdministrationType;
import com.example.pharmapal.Entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.Entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.Entities.TherapeuticClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TherapeuticClassMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(TherapeuticClassDTO  therapeuticClassDTO, TherapeuticClass therapeuticClass){
        modelMapper.map(therapeuticClassDTO, therapeuticClass);
    }
}
