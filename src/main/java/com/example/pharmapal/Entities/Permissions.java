package com.example.pharmapal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore; // Add this annotation
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "Permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String permission;

    private String description;

    @ManyToMany(mappedBy = "permissions", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private Set<Staff> staffSet;
}
