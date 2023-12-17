package com.example.pharmapal.Repositories;

import com.example.pharmapal.Entities.TherapeuticClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapeuticClassRepository extends JpaRepository<TherapeuticClass, Long> {

    boolean existsByName(String name);
    boolean existsByDescription(String description);



}
