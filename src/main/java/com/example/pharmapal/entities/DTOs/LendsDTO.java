package com.example.pharmapal.entities.DTOs;

import com.example.pharmapal.entities.Products;
import lombok.Data;

@Data
public class LendsDTO {


        private Long id;

        private String pharmacyName;
        private String pharmacyId;

        private int quantity;

        private Products Products;

    }

