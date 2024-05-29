package com.example.pharmapal.entities;

import com.example.pharmapal.entities.Compositekeys.BillsKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table(schema = "PharmaPal", name = "Bills")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BillsKey.class)
public class Bills {
    @Id
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Id
    @JoinColumn(name = "supplier", foreignKey = @ForeignKey(name = "fk_supplier"))
    private Suppliers supplier;
    @Temporal(TemporalType.DATE)
    private LocalDate billDate;

    private double total;
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    private String State;


    @OneToMany(mappedBy = "bills", cascade = CascadeType.ALL)
    private Set<StockedProducts> stockedProducts;



}