package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {

    public boolean existsByPhone(double phone);
    public boolean existsByEmail(String email);
    public boolean existsByPhoneAndIdNot(double phone, Long id);
    public boolean existsByEmailAndIdNot(String email, Long id);
}
