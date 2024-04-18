package com.example.pharmapal.Entities.DTOs;

import com.example.pharmapal.Entities.Products;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class LendsDTO {


        private Long id;

        private String pharmacyName;
        private String pharmacyId;

        private int quantity;

        private Products Products;

    }

