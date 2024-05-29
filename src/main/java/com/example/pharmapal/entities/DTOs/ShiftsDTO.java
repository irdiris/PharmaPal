package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ShiftsDTO {


    private Long id;

    private LocalTime shiftStart;

    private LocalTime shiftEnd;


    private Set<Staff> staff;
}
