package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Transactions")
@Entity
@Data
public class Transactions {

    @Id
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Staff  staff;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    private  double total;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private Set<PsychotropicDrugSales> psychotropicDrugSales;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private Set<ProductsSold> productsSold;

}
