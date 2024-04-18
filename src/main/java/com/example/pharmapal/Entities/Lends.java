package com.example.pharmapal.Entities;

import com.example.pharmapal.Entities.Enumerations.LendStates;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(schema = "PharmaPal" , name = "Lends")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lends {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private LendStates state;

    private String pharmacyName;
    private String pharmacyId;

    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate date;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "lends")
    private Products Products;


}
