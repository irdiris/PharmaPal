package com.example.pharmapal.Entities;

import com.example.pharmapal.Entities.Compositekeys.BillsKey;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table(schema = "PharmaPal", name = "Bills")
@Entity
@IdClass(BillsKey.class)
public class Bills {
    @Id
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate billDate;

    private double total;
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    private String State;


    @ManyToOne
    @Id
    @MapsId("supplierId")
    @JoinColumn(name = "supplier", foreignKey = @ForeignKey(name = "fk_supplier"))
    private Suppliers supplier;

    @OneToMany(mappedBy = "bills", cascade = CascadeType.ALL)
    private Set<StockedProducts> stockedProducts;



}
