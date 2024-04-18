package com.example.pharmapal.Entities;

import com.example.pharmapal.Entities.Compositekeys.StockedProductsKey;
import com.example.pharmapal.Entities.Enumerations.LendStates;
import com.example.pharmapal.Entities.Enumerations.StockedProductsState;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Table(schema = "PharmaPal", name = "StockedProducts")
@Entity
@Data
@IdClass(StockedProductsKey.class)
public class StockedProducts {
    @Id
    private String lotNumber;

    @Id
    @ManyToOne
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_product"))
    private Products product;


    @Id
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_billId")),
            @JoinColumn(name = "supplier", foreignKey = @ForeignKey(name = "fk_billSupplier"))
    })
    private Bills bills;

    @Column
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate expirationDate;

    @Column
    private double unitPrice;

    @Column
    private double margin;

    @Column
    private double ppa;

    @Column
    private double shp;

    @Column
    private double tv;

    @Column
    private double tht;

    @Enumerated(EnumType.STRING)
    private StockedProductsState state;


    @OneToMany(mappedBy = "stockedProducts")
    private Set<ProductsSold> productsSold;

    @OneToMany(mappedBy = "stockedProducts")
    private Set<PsychotropicDrugSales> psychotropicDrugSales;

}
