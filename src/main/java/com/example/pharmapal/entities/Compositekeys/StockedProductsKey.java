package com.example.pharmapal.entities.Compositekeys;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.Products;

import java.io.Serializable;

public class StockedProductsKey implements Serializable {
    private String lotNumber;
    private Products product;
    private Bills bills;
}
