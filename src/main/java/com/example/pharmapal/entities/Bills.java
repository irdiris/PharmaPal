package com.example.pharmapal.entities;

import com.example.pharmapal.entities.Compositekeys.BillsKey;
import com.example.pharmapal.entities.Enumerations.BillTypes;
import com.example.pharmapal.entities.Enumerations.UserTypes;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table(schema = "pharma_pal" ,name = "Bills")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BillsKey.class)
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Bills {
    @Id
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @Id
    @JoinColumn(name = "supplier", foreignKey = @ForeignKey(name = "fk_supplier"))
    private Suppliers supplier;
    @Temporal(TemporalType.DATE)
    private LocalDate billDate;

    private double total;
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private BillTypes state;


    @OneToMany(mappedBy = "bills", cascade = CascadeType.ALL)
    private Set<StockedProducts> stockedProducts;



}