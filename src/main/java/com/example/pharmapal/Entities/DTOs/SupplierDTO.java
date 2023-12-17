package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Bills;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
public class SupplierDTO {

    private Long id;

    private String name;
    private int phone;
    private int fax;
    private String website;
    private String address;
    private String email;
    private String state;
    private int RC; // Registre de commerce
    private int NIF; // numero identification fiscal
    private int NAI; // numero articles d'imposition
    private int NIS; // numero identification static
    private int RIB; // compte bancaire

    private Set<Bills> bills;
}
