package com.example.pharmapal.entities.mappers;

import com.example.pharmapal.entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.entities.TherapeuticClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TherapeuticClassMapper {

    private  final ModelMapper modelMapper = new ModelMapper();


    public void mapFromDto(TherapeuticClassDTO  therapeuticClassDTO, TherapeuticClass therapeuticClass){
        modelMapper.map(therapeuticClassDTO, therapeuticClass);
    }
}
