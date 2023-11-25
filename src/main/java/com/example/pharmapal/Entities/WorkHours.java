package com.example.pharmapal.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Table(schema = "PharmaPal", name = "WorkHours")
@Data
@Entity
public class WorkHours {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;

    @ManyToOne
    @JsonIgnore
    private Staff staff;



}
