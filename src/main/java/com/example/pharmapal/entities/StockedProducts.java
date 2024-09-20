package com.example.pharmapal.entities;

import com.example.pharmapal.entities.compositekeys.StockedProductsKey;
import com.example.pharmapal.entities.enumerations.StockedProductsState;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Table(schema = "PharmaPal", name = "StockedProducts")
@Entity
@Data
@IdClass(StockedProductsKey.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.UUIDGenerator.class,
        property = "@lotNumber"
)
public class StockedProducts {
    @Id
    private String lotNumber;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_product"), referencedColumnName = "productId")
    private Products product;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_billId")),
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

    @OneToMany(cascade = CascadeType.ALL)
    private Set<LentItems> lentItems;
}
