package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(schema = "PharmaPal", name = "IndebtedClient")
@Data
@Entity
public class IndebtedClient {
    @Id
    private Long id;

    private String type;
    private String debtState;
    private int debt;
    private int relativeContact;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
