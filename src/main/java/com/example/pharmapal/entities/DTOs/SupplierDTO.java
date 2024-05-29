package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Bills;
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
