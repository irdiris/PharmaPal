package com.example.pharmapal.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Shifts")
@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftStart;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftEnd;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "shifts")
    @JsonIgnore
    private Set<Staff> staff;

}
