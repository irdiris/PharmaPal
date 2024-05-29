package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.TherapeuticClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapeuticClassRepository extends JpaRepository<TherapeuticClass, Long> {

    boolean existsByName(String name);
    boolean existsByDescription(String description);



}
