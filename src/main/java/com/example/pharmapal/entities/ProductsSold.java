package com.example.pharmapal.entities;

import com.example.pharmapal.entities.compositekeys.ProductsSoldKey;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "PharmaPal", name = "ProductsSold")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@productsSoldId"
)
@IdClass(ProductsSoldKey.class)
public class ProductsSold {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productsSoldId;

    @ManyToOne (cascade = CascadeType.ALL)
    private  StockedProducts  stockedProducts;

    @ManyToOne
    @Id
    private Transactions transaction;

    private double price;

    private int quantity;

}
