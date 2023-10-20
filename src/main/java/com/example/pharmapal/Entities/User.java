package com.example.pharmapal.Entities;

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
    private int phone;
    private String email;
    private String Type;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Staff staff;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private IndebtedClient indebtedClient;


    @OneToMany(mappedBy = "user")
    private Set<Transactions> transactionsSet;



}
