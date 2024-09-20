package com.example.pharmapal.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(schema = "PharmaPal", name = "ProductForm")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@productFormId"
)
public class ProductForm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productFormId;

    private String form;

    private String description;

    @OneToMany(mappedBy = "productForm")

    private Set<Products> productsSet;

}
