package com.example.pharmapal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(schema = "PharmaPal", name = "ProductsSold")
public class ProductsSold {
    @Id

    private Long id;

    @ManyToOne
    private  StockedProducts  stockedProducts;

@ManyToOne
    private Transactions transaction;


private double price;

}
