package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(schema = "PharmaPal" , name = "Lends")
@Entity
@Data
public class Lends {
    @Id
    private Long id;

    private String pharmacyName;
    private String pharmacyId;

    @ManyToOne
    @JoinColumn(name = "lends")
    private Products products;

}
