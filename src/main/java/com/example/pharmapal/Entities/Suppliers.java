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
   private double phone;
   private double fax;
   private String website;
   private String address;
   private String email;
    private String state;
   private double RC; // Registre de commerce
    private double NIF; // numero identification fiscal
    private double NAI; // numero articles d'imposition
    private double NIS; // numero identification static
    private double RIB; // compte bancaire

    @OneToMany(mappedBy = "supplier")
    private Set<Bills> bills;
}
