package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.enumerations.StaffStates;
import com.example.pharmapal.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository  extends JpaRepository<Staff, Long> {

    public Optional<Staff> findByStaffIdAndState(Long id, StaffStates staffStates);

}
