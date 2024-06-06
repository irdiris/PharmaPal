package com.example.pharmapal.entities;

import com.example.pharmapal.entities.Enumerations.LendStates;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            schema = "PharmaPal",
            name = "StaffShifts",
            joinColumns = @JoinColumn(name = "staffid",foreignKey = @ForeignKey(name = "fk_staff")),
            inverseJoinColumns = @JoinColumn(name = "shiftId"), foreignKey = @ForeignKey(name = "fk_shifts"))

    private Set<Products> Products;


}
