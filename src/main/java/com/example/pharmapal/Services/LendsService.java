package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.LendsDTO;
import com.example.pharmapal.Entities.Enumerations.LendStates;
import com.example.pharmapal.Entities.Lends;
import com.example.pharmapal.ExceptionHandling.LendsExceptionHandling.Exceptions.LendDoesNotExistException;
import com.example.pharmapal.Interfaces.LendsServiceInterface;
import com.example.pharmapal.Repositories.LendsRepository;
import com.example.pharmapal.Requests.LendsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LendsService implements LendsServiceInterface {

    private final LendsRepository lendsRepository;
@Autowired
    public LendsService(LendsRepository lendsRepository) {
        this.lendsRepository = lendsRepository;
    }

    @Override
    public List<Lends> getLends() {
        return lendsRepository.findAll();
    }

    @Override
    public String addLend(Lends lend) {
    // FIX SO IT CHECKS FOR STOCK AVAILABILITY AND DATE OF EXPIRATION
             lendsRepository.save(lend);
       return "lend registered.";
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
