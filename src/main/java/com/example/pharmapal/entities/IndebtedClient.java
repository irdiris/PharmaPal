package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Table(schema = "PharmaPal", name = "IndebtedClient")
@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@clientId"
)
public class IndebtedClient {
    @Id
    private Long clientId;

    private String type;
    private String debtState;
    private int debt;
    private int relativeContact;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
