package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.StockedProductsDTO;
import com.example.pharmapal.Entities.Mappers.StockedProductsMapper;
import com.example.pharmapal.Entities.StockedProducts;
import com.example.pharmapal.ExceptionHandling.StockedProductsExceptionHandling.Exceptions.ExpirationDateOutOfRange;
import com.example.pharmapal.ExceptionHandling.StockedProductsExceptionHandling.Exceptions.ProductIsNotStocked;
import com.example.pharmapal.Interfaces.StockedProductsServiceInterface;
import com.example.pharmapal.Repositories.StockedProductsRepository;
import com.example.pharmapal.Requests.StockedProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockedProductService implements StockedProductsServiceInterface {
      private final StockedProductsRepository stockedProductsRepository;
      private final StockedProductsMapper stockedProductsMapper;
@Autowired
    public StockedProductService(StockedProductsRepository stockedProductsRepository, StockedProductsMapper stockedProductsMapper) {
        this.stockedProductsRepository = stockedProductsRepository;
    this.stockedProductsMapper = stockedProductsMapper;
}

    @Override
    public List<StockedProducts> getStockedProducts() {
       return stockedProductsRepository.findAll();
    }

    @Override
    public String stockProducts(StockedProducts stockedProducts) {
          Optional<StockedProducts> possibleStockedProduct = stockedProductsRepository.findByLotNumber(stockedProducts.getLotNumber());

          if (possibleStockedProduct.isPresent()){
              Integer quantity = possibleStockedProduct.get().getQuantity() + stockedProducts.getQuantity();
              possibleStockedProduct.get().setQuantity(quantity);
              stockedProductsRepository.save(possibleStockedProduct.get());
              return "This batch already exists, the new batch was registered under it.";

          }else{
               stockedProductsRepository.save(stockedProducts);
               return "batch registered";
          }
    }

    @Override
    public String updateStockedProduct(StockedProductsDTO stockedProductsDTO) {
          StockedProducts stockedProducts = stockedProductsRepository.findByLotNumberAndBillsAndProduct(stockedProductsDTO.getLotNumber(), stockedProductsDTO.getBills(), stockedProductsDTO.getProduct())
                  .orElseThrow(()-> new ProductIsNotStocked("This product is not in the inventory "));
          if(stockedProductsDTO.getExpirationDate().isBefore(LocalDate.now())){
                  stockedProductsMapper.mapStockedProductsFromDto(stockedProductsDTO, stockedProducts);
                  stockedProductsRepository.save(stockedProducts);
                  return ("Stocked product updated");}else{
              throw new ExpirationDateOutOfRange("this batch is already expired.");
        }
    }

    @Override
    public String deleteStockedProduct(StockedProductsRequest stockedProductsRequest) {
    StockedProducts stockedProducts = stockedProductsRepository.findByLotNumberAndBillsAndProduct(stockedProductsRequest.getLotNumber(), stockedProductsRequest.getBills(), stockedProductsRequest.getProducts())
            .orElseThrow(()-> new ProductIsNotStocked("This product is not in the inventory "));
          stockedProductsRepository.delete(stockedProducts);
          return "batch deleted.";
    }


}
