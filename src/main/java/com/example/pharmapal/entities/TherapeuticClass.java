package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "PharmaPal", name = "TherapeuticClass")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@tClassId"
)
public class TherapeuticClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tClassId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "therapeuticClass")
    private Set<Products> productsSet;
}
