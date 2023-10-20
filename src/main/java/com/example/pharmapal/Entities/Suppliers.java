package com.example.pharmapal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Table(schema = "PharmaPal", name = "Suppliers")
@Entity
public class Suppliers {
    @Id
    private Long id;

   private String name;
   private int phone;
   private int fax;
   private String website;
   private String address;
   private String email;
   private int RC; // Registre de commerce
    private int NIF; // numero identification fiscal
    private int NAI; // numero articles d'imposition
    private int NIS; // numero identification static
    private int RIB; // compte bancaire

    @OneToMany(mappedBy = "supplier")
    private Set<Bills> bills;
}
