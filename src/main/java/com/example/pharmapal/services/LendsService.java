package com.example.pharmapal.services;

import com.example.pharmapal.entities.DTOs.LendsDTO;
import com.example.pharmapal.entities.Enumerations.LendStates;
import com.example.pharmapal.entities.Lends;
import com.example.pharmapal.entities.LentItems;
import com.example.pharmapal.entities.StockedProducts;
import com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions.LendDoesNotExistException;
import com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions.NoProductLeftException;
import com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions.ProductNearlyExpiredException;
import com.example.pharmapal.exceptionHandling.stockedProductsExceptionHandling.exceptions.ProductIsNotStocked;
import com.example.pharmapal.interfaces.LendsServiceInterface;
import com.example.pharmapal.repositories.LendsRepository;
import com.example.pharmapal.repositories.LentItemsRepository;
import com.example.pharmapal.repositories.StockedProductsRepository;
import com.example.pharmapal.requests.LendsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class LendsService implements LendsServiceInterface {

    private final LendsRepository lendsRepository;
    private final LentItemsRepository lentItemsRepository;
    private final StockedProductsRepository stockedProductsRepository;
@Autowired
    public LendsService(LendsRepository lendsRepository, LentItemsRepository lentItemsRepository, StockedProductsRepository stockedProductsRepository) {
        this.lendsRepository = lendsRepository;
    this.lentItemsRepository = lentItemsRepository;


    this.stockedProductsRepository = stockedProductsRepository;
}

    @Override
    public List<Lends> getLends() {
        List<Lends> lends = lendsRepository.findAll();
        for (Lends lend : lends){
            lend.setLentItems(lentItemsRepository.findAllByLend(lend));
        }
        return lends;
    }

    @Override
    public String addLend(Lends lend) {
        Set<LentItems> lentItems = lend.getLentItems();
        for (LentItems lentItem : lentItems) {
            StockedProducts stockedProduct = stockedProductsRepository.findByLotNumberAndBillsAndProduct(
                    lentItem.getStockedProducts().getLotNumber(),
                    lentItem.getStockedProducts().getBills(),
                    lentItem.getStockedProducts().getProduct()
            ).orElseThrow(() -> new ProductIsNotStocked("this product is not in inventory."));

            if (stockedProduct.getExpirationDate().minusDays(30).isBefore(LocalDate.now())) {
                if (stockedProduct.getQuantity() <= lentItem.getQuantity()) {
                    throw new NoProductLeftException("you don't have enough in inventory");
                }
            } else {
                throw new ProductNearlyExpiredException("This product expires in 30 days");
            }
        }

        lendsRepository.save(lend);
        return "lend saved";
    }

    @Override
    public String updateLend(LendsDTO lendsDTO) {
        return null;
    }

    @Override
    public String closeLend(LendsRequest lendsRequest) {
        Lends lendToBeClosed = lendsRepository.findById(lendsRequest.getId()).orElseThrow(()-> new LendDoesNotExistException("this lend is not registered."));
        lendToBeClosed.setState(LendStates.CLOSED);
        lendsRepository.save(lendToBeClosed);
        return "Lend closed";
    }
}
