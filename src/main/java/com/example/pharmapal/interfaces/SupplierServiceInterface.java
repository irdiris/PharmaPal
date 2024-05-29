package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.DTOs.BillsDTO;
import com.example.pharmapal.entities.DTOs.SupplierDTO;
import com.example.pharmapal.entities.Suppliers;
import com.example.pharmapal.requests.BillsRequest;

import java.util.List;

public interface SupplierServiceInterface {

    public List<Suppliers> getSuppliers();

    public String addSupplier(Suppliers supplier);

    public String updateSupplier(SupplierDTO supplierDTO);
}
