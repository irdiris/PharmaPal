package com.example.pharmapal.Repositories;

import com.example.pharmapal.Entities.Bills;
import com.example.pharmapal.Entities.Products;
import com.example.pharmapal.Entities.StockedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockedProductsRepository  extends JpaRepository<StockedProducts, StockedProducts> {


    Optional<StockedProducts> findByLotNumber(String lotNumber);
    Optional<StockedProducts> findByLotNumberAndBillsAndProduct(String lotNumber, Bills bills, Products products);
}
