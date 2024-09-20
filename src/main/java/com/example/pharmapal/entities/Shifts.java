package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@shiftId"
)
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long shiftId;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftStart;
    @Temporal(TemporalType.TIME)
   private LocalTime shiftEnd;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "shifts", fetch = FetchType.LAZY)
    private Set<Staff> staff;

}
