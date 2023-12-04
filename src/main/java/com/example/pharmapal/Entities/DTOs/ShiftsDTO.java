package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Staff;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
