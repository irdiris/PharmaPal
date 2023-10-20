package com.example.pharmapal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "PharmaPal", name = "PsychotropicDrugSales")
public class PsychotropicDrugSales {
    @Id
    private Long id;

@ManyToOne
    private StockedProducts stockedProducts;


@ManyToOne
    private Transactions transaction;

    private Long clientId;
}
