package com.example.pharmapal.entities;

import com.example.pharmapal.entities.enumerations.PermissionsEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "Permissions")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id"
)
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PermissionsEnum permissions;

    private String description;

    @ManyToMany(mappedBy = "permissions", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})

    private Set<Staff> staffSet;
}
