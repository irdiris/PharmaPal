package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByPhone(double phone);
    public boolean existsByEmail(String email);
    public boolean existsByPhoneAndIdNot(double phone, Long id);
    public boolean existsByEmailAndIdNot(String email, Long id);
}
