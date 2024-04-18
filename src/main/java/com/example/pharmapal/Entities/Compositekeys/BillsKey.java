package com.example.pharmapal.Entities.Compositekeys;

import com.example.pharmapal.Entities.Suppliers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillsKey implements Serializable {

    private Suppliers supplier;

    private int id;


}
