package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Permissions;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.User;
import com.example.pharmapal.Entities.WorkHours;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
