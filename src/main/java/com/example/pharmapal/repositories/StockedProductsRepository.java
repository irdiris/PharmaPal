package com.example.pharmapal.repositories;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.Lends;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.entities.StockedProducts;
import com.example.pharmapal.entities.enumerations.StockedProductsState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StockedProductsRepository  extends JpaRepository<StockedProducts, StockedProducts> {


    Optional<StockedProducts> findByLotNumber(String lotNumber);
    Optional<StockedProducts> findByLotNumberAndBillsAndProduct(String lotNumber, Bills bills, Products products);
    Set<StockedProducts> findAllByProduct (Products products);
    Set<StockedProducts> findAllByBills (Bills bills);
    int countAllByExpirationDateIsBefore(LocalDate expirationDate);
    int countAllByExpirationDateBetween(LocalDate today, LocalDate sixtyDaysFromNow);
    List<StockedProducts> findAllByState(StockedProductsState state);

}
