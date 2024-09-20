package com.example.pharmapal.entities.compositekeys;

import com.example.pharmapal.entities.Suppliers;
import lombok.Data;

import java.io.Serializable;

@Data
public class BillsKey implements Serializable {

    private Suppliers supplier;

    private Long billId;


}
