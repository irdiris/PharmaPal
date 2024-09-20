package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Transactions")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@transId"
)
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transId;

    @ManyToOne
    private Staff  staff;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    private  double total;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private Set<PsychotropicDrugSales> psychotropicDrugSales = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ProductsSold> productsSold = new HashSet<>();

}
