package com.example.pharmapal.Entities.Mappers;
import org.modelmapper.ModelMapper;


import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StaffMapper {
  private  final ModelMapper modelMapper = new ModelMapper();


  public void mapStaffFromDto(StaffDTO staffDTO, Staff staff){
      modelMapper.map(staffDTO, staff);
  }



}
