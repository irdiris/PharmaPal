package com.example.pharmapal.Repositories;

import com.example.pharmapal.Entities.Enumerations.StaffStates;
import com.example.pharmapal.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository  extends JpaRepository<Staff, Long> {

    public Optional<Staff> findByIdAndState(Long id, StaffStates staffStates);

}
