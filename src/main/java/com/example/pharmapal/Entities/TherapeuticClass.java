package com.example.pharmapal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "TherapeuticClass ")
public class TherapeuticClass {
    @Id
    private Long id;

    private String name;

    private String description;

    @OneToMany
    private Set<Products> productsSet;

}
