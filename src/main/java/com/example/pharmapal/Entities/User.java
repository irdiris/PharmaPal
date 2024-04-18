package com.example.pharmapal.Entities;

import com.example.pharmapal.Entities.Enumerations.StaffStates;
import com.example.pharmapal.Entities.Enumerations.UserTypes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Entity
@Table( schema = "PharmaPal", name = "User")
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private String address;
    private double phone;
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(name = "userType")
    private UserTypes type;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Staff staff;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private IndebtedClient indebtedClient;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, email, type);
    }





}
