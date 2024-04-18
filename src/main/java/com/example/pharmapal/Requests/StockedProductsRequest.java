package com.example.pharmapal.Requests;

import com.example.pharmapal.Entities.Bills;
import com.example.pharmapal.Entities.Products;
import lombok.Data;

@Data
public class StockedProductsRequest {

    private String lotNumber;
    private Products products;
    private Bills bills;
}
