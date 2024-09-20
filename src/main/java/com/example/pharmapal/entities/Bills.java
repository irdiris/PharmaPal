package com.example.pharmapal.entities;

import com.example.pharmapal.entities.compositekeys.BillsKey;
import com.example.pharmapal.entities.enumerations.BillStates;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table(schema = "pharma_pal" ,name = "Bills")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BillsKey.class)
public class Bills {
    @Id

    private Long billId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Id
    @JoinColumn(name = "supplier", foreignKey = @ForeignKey(name = "fk_supplier"))

    private Suppliers supplier;
    @Temporal(TemporalType.DATE)
    private LocalDate billDate;

    private double total;
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private BillStates state;


    @OneToMany(mappedBy = "bills", cascade = CascadeType.ALL)

    private Set<StockedProducts> stockedProducts;



}