package com.example.pharmapal.Repositories;

import com.example.pharmapal.Entities.AdministrationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrationTypeRepository extends JpaRepository<AdministrationType, Long> {


    boolean existsByForm(String form);
    boolean existsByDescription(String description);
}
