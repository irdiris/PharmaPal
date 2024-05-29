package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.AdministrationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrationTypeRepository extends JpaRepository<AdministrationType, Long> {


    boolean existsByForm(String form);
    boolean existsByDescription(String description);
}
