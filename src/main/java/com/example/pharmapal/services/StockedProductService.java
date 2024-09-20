package com.example.pharmapal.services;

import com.example.pharmapal.entities.Bills;
import com.example.pharmapal.entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.entities.enumerations.StockedProductsState;
import com.example.pharmapal.entities.mappers.StockedProductsMapper;
import com.example.pharmapal.entities.Products;
import com.example.pharmapal.entities.StockedProducts;
import com.example.pharmapal.exceptionHandling.stockedProductsExceptionHandling.exceptions.ExpirationDateOutOfRange;
import com.example.pharmapal.exceptionHandling.stockedProductsExceptionHandling.exceptions.ProductIsNotStocked;
import com.example.pharmapal.interfaces.BillsServiceInterface;
import com.example.pharmapal.interfaces.ProductsServiceInterface;
import com.example.pharmapal.interfaces.StockedProductsServiceInterface;
import com.example.pharmapal.repositories.StockedProductsRepository;
import com.example.pharmapal.requests.StockedProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StockedProductService implements StockedProductsServiceInterface {
    private final StockedProductsRepository stockedProductsRepository;
    private final StockedProductsMapper stockedProductsMapper;
    private final BillsServiceInterface billsService;
    private final ProductsServiceInterface productsService;

    @Autowired
    public StockedProductService(StockedProductsRepository stockedProductsRepository, StockedProductsMapper stockedProductsMapper, BillsService billsService, ProductsService productsService) {
        this.stockedProductsRepository = stockedProductsRepository;
        this.stockedProductsMapper = stockedProductsMapper;
        this.billsService = billsService;


        this.productsService = productsService;
    }

    @Override
    public List<StockedProducts> getStockedProducts() {
        return stockedProductsRepository.findAll();
    }

    @Override
    public String stockProducts(StockedProducts stockedProducts) {
        Bills bills = billsService.getBill(stockedProducts.getBills().getBillId(), stockedProducts.getBills().getSupplier());
        Products products = productsService.getProduct(stockedProducts.getProduct().getProductId());
        Optional<StockedProducts> possibleStockedProduct = stockedProductsRepository.findByLotNumber(stockedProducts.getLotNumber());

        if (possibleStockedProduct.isPresent()) {
            Integer quantity = possibleStockedProduct.get().getQuantity() + stockedProducts.getQuantity();
            possibleStockedProduct.get().setQuantity(quantity);
            stockedProductsRepository.save(possibleStockedProduct.get());
            return "This batch already exists, the new batch was registered under it.";

        } else {
            stockedProducts.setProduct(products);
            stockedProducts.setBills(bills);

            System.out.println(stockedProducts);
            stockedProductsRepository.save(stockedProducts);
            return "batch registered";
        }
    }

    @Override
    public String updateStockedProduct(StockedProductsDTO stockedProductsDTO) {
        StockedProducts stockedProducts = stockedProductsRepository.findByLotNumberAndBillsAndProduct(stockedProductsDTO.getLotNumber(), stockedProductsDTO.getBills(), stockedProductsDTO.getProduct())
                .orElseThrow(() -> new ProductIsNotStocked("This product is not in the inventory "));
        if (stockedProductsDTO.getExpirationDate().isBefore(LocalDate.now())) {
            stockedProductsMapper.mapStockedProductsFromDto(stockedProductsDTO, stockedProducts);
            stockedProductsRepository.save(stockedProducts);
            return ("Stocked product updated");
        } else {
            throw new ExpirationDateOutOfRange("this batch is already expired.");
        }
    }

    @Override
    public String deleteStockedProduct(StockedProductsRequest stockedProductsRequest) {
        StockedProducts stockedProducts = stockedProductsRepository.findByLotNumberAndBillsAndProduct(stockedProductsRequest.getLotNumber(), stockedProductsRequest.getBills(), stockedProductsRequest.getProducts())
                .orElseThrow(() -> new ProductIsNotStocked("This product is not in the inventory "));
        stockedProductsRepository.delete(stockedProducts);
        return "batch deleted.";
    }

    @Override
    public Set<StockedProducts> getRelatedStockedProducts(Products products) {

        return stockedProductsRepository.findAllByProduct(products);
    }

    @Override
    public int getCloseExpirationProducts() {
        return stockedProductsRepository.countAllByExpirationDateIsBefore(LocalDate.now().plusDays(30));
    }

    @Override
    public int getNearExpirationProducts() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        LocalDate sixtyDaysFromNow = LocalDate.now().plusDays(60);
        return stockedProductsRepository.countAllByExpirationDateBetween(thirtyDaysFromNow, sixtyDaysFromNow);
    }

    @Override
    public List<StockedProducts> getAvailableProducts() {
        List<StockedProducts> stockedProducts = stockedProductsRepository.findAllByState(StockedProductsState.IN_STOCK);
        stockedProducts.forEach(stockedProduct -> {
            Bills updatedBill = billsService.getBill(
                    stockedProduct.getBills().getBillId(),
                    stockedProduct.getBills().getSupplier()
            );
            stockedProduct.setBills(updatedBill);
        });
        return stockedProducts;
    }
}
