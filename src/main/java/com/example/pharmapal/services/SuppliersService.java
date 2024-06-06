package com.example.pharmapal.services;

import com.example.pharmapal.entities.DTOs.SupplierDTO;
import com.example.pharmapal.entities.Mappers.SuppliersMapper;
import com.example.pharmapal.entities.Suppliers;
import com.example.pharmapal.exceptionHandling.suppliersExceptionHandling.exceptions.SupplierAlreadyExists;
import com.example.pharmapal.exceptionHandling.suppliersExceptionHandling.exceptions.SupplierNotFound;
import com.example.pharmapal.interfaces.SupplierServiceInterface;
import com.example.pharmapal.repositories.BillsRepository;
import com.example.pharmapal.repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService  implements SupplierServiceInterface {

    private final SuppliersRepository suppliersRepository;

    private final SuppliersMapper supplierMapper;
    private final BillsRepository billsRepository;
@Autowired
    public SuppliersService(SuppliersRepository suppliersRepository, SuppliersMapper supplierMapper, BillsRepository billsRepository) {

    this.suppliersRepository = suppliersRepository;

    this.supplierMapper = supplierMapper;
    this.billsRepository = billsRepository;
}

    public List<Suppliers> getSuppliers(){
         List<Suppliers> suppliers = suppliersRepository.findAll();
         for (Suppliers supplier : suppliers){
             supplier.setBills(billsRepository.findAllBySupplier(supplier));
         }
         return  suppliers;
    }


    public String addSupplier(Suppliers supplier){

        if (!suppliersRepository.existsById(supplier.getId())) {
            if (!suppliersRepository.existsByPhone(supplier.getPhone())) {
                if (!suppliersRepository.existsByEmail(supplier.getEmail())) {
                    suppliersRepository.save(supplier);
                    return "supplier registered";
                } else {
                    throw new SupplierAlreadyExists("This email already exists");
                }
            } else {
                throw new SupplierAlreadyExists("this phone number already exists");
            }
        } else {
            throw new SupplierAlreadyExists("This user already exists");
        }
    }

    public String updateSupplier(SupplierDTO supplierDTO){
        Suppliers preUpdateSupplier = suppliersRepository.findById(supplierDTO.getId()).orElseThrow(()-> new SupplierNotFound("this supplier doesn't exist."));

        if (!suppliersRepository.existsByEmailAndIdNot(supplierDTO.getEmail(), supplierDTO.getId())) {
            if (!suppliersRepository.existsByPhoneAndIdNot(supplierDTO.getPhone(), supplierDTO.getId())) {
                supplierMapper.mapSupplierFromDto(supplierDTO, preUpdateSupplier);
                suppliersRepository.save(preUpdateSupplier);
                return "supplier information updated successfully.";
            } else {
                throw new SupplierAlreadyExists("this phone number already exists.");
            }
        } else {
            throw new SupplierAlreadyExists("this email already exists.");
        }

    }

}
