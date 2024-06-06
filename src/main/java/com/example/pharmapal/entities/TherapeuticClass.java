package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "TherapeuticClass ")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TherapeuticClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "therapeuticClass")

    private Set<Products> productsSet;

}
