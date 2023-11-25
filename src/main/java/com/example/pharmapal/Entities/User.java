package com.example.pharmapal.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

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
    private String Type;
    private String state;
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Staff staff;
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private IndebtedClient indebtedClient;




}
