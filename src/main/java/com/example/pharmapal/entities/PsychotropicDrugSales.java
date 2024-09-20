package com.example.pharmapal.entities;

import com.example.pharmapal.entities.compositekeys.PsychotropicDrugSalesKey;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "PharmaPal", name = "PsychotropicDrugSales")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@psychoMedId"
)
@IdClass(PsychotropicDrugSalesKey.class)
public class PsychotropicDrugSales {
    @Id
    private Long psychoMedId;

    @ManyToOne(cascade = CascadeType.ALL)
    private StockedProducts stockedProducts;


    @ManyToOne
    @Id
    private Transactions transaction;

    private Long clientId;

    private int quantity;
}
