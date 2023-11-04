package com.example.pharmapal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
@Table(schema = "PharmaPal", name = "WorkHours")
@Data
@Entity
public class WorkHours {
    @Id
    private Long id;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;

    @ManyToOne
    private Staff staff;



}
