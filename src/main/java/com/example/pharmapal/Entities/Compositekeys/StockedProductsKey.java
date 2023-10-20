package com.example.pharmapal.Entities.Compositekeys;

import com.example.pharmapal.Entities.Bills;
import com.example.pharmapal.Entities.Products;

import java.io.Serializable;

public class StockedProductsKey implements Serializable {
    private String lotNumber;
    private Products product;
    private Bills bills;
}
