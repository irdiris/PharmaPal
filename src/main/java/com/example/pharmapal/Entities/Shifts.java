package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Shifts")
@Entity
@Data
public class Shifts {
    @Id
    private Long id;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftStart;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftEnd;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shifts")
    private Set<WorkHours> workHoursSet;

    @ManyToMany
    private Set<Staff> staff;

}
