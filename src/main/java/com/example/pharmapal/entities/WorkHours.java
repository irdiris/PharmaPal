package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(schema = "PharmaPal", name = "WorkHours")
@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@workHoursId"
)
public class WorkHours {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long workHoursId;
    private LocalTime clockIn;
    private LocalTime clockOut;
    private LocalDate shiftDate;
    private boolean shiftEnded;
    @ManyToOne

    private Staff staff;



}
