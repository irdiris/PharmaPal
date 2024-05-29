package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Permissions;
import com.example.pharmapal.entities.Shifts;
import com.example.pharmapal.entities.User;
import com.example.pharmapal.entities.WorkHours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StaffDTO {

    private Long id;
    private String username;
    private String password;
    private String state;
    private String type;



    private User user;

    private Set<WorkHours> workHoursSet;


    private Set<Shifts> shifts;


    private Set<Permissions> permissions;


}
