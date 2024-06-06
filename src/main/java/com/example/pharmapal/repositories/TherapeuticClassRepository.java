package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.TherapeuticClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TherapeuticClassRepository extends JpaRepository<TherapeuticClass, Long> {

    boolean existsByName(String name);
    boolean existsByDescription(String description);
    @Query("SELECT tc FROM TherapeuticClass tc LEFT JOIN FETCH tc.productsSet")
    List<TherapeuticClass> findAllWithProducts();


}
