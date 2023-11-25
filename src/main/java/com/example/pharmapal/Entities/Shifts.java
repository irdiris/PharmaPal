package com.example.pharmapal.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Shifts")
@Entity
@Data
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftStart;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftEnd;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shifts")
    private Set<Staff_Shifts> staffShifts;

}
