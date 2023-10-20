package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "Permissions")
public class Permissions {
    @Id
    private Long id;
    private String permission;
@ManyToMany

     private Set<Staff> staffSet;
}
