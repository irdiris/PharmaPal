package com.example.pharmapal.entities;

import com.example.pharmapal.entities.enumerations.UserTypes;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table( schema = "PharmaPal", name = "User")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@userId"
)
public class User {
    @Id
    private Long userId;
    private String name;
    private String address;
    private double phone;
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(name = "userType")
    private UserTypes type;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Staff staff;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private IndebtedClient indebtedClient;

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, address, phone, email, type);
    }





}
