package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.SupplierDTO;
import com.example.pharmapal.Entities.Mappers.SuppliersMapper;
import com.example.pharmapal.Entities.Suppliers;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberNotFoundException;
import com.example.pharmapal.ExceptionHandling.SuppliersExceptionHandling.Exceptions.SupplierAlreadyExists;
import com.example.pharmapal.Interfaces.SupplierServiceInterface;
import com.example.pharmapal.Repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService  implements SupplierServiceInterface {

    private final SuppliersRepository suppliersRepository;
    private final SuppliersMapper supplierMapper;

@Autowired
    public SuppliersService(SuppliersRepository suppliersRepository, SuppliersMapper supplierMapper) {

    this.suppliersRepository = suppliersRepository;

    this.supplierMapper = supplierMapper;
}

    public List<Suppliers> getSuppliers(){
   return suppliersRepository.findAll();
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
        Suppliers preUpdateSupplier = suppliersRepository.findById(supplierDTO.getId()).orElseThrow(()-> new StaffMemberNotFoundException("this supplier doesn't exist."));

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
