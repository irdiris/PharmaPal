package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Long> {
    boolean existsByShiftStartAndShiftEnd(LocalTime shiftStart, LocalTime shiftEnd);
}
