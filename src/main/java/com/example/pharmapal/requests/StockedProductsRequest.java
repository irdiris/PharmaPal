package com.example.pharmapal.requests;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.Products;
import lombok.Data;

@Data
public class StockedProductsRequest {

    private String lotNumber;
    private Products products;
    private Bills bills;
}
