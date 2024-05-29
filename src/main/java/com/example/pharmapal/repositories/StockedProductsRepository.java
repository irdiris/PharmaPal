package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.entities.StockedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockedProductsRepository  extends JpaRepository<StockedProducts, StockedProducts> {


    Optional<StockedProducts> findByLotNumber(String lotNumber);
    Optional<StockedProducts> findByLotNumberAndBillsAndProduct(String lotNumber, Bills bills, Products products);
}
