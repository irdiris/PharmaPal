package com.example.pharmapal.entities.Mappers;
import org.modelmapper.ModelMapper;


import com.example.pharmapal.entities.DTOs.StaffDTO;
import com.example.pharmapal.entities.Staff;
import org.springframework.stereotype.Service;



@Service
public class StaffMapper {
  private  final ModelMapper modelMapper = new ModelMapper();


  public void mapStaffFromDto(StaffDTO staffDTO, Staff staff){
      modelMapper.map(staffDTO, staff);
  }



}
