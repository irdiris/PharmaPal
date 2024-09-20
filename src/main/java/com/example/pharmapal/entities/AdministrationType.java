package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity
@Data
@Table(schema = "PharmaPal", name = "AdministrationType")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@adminTypeId"
)
public class AdministrationType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administration_type_seq")
    private Long adminTypeId;

    private String form;

    private String description;

    @OneToMany(mappedBy ="administrationType" )

    private Set<Products> productsSet;
}
