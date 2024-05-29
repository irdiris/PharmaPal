package com.example.pharmapal.interfaces;


import com.example.pharmapal.entities.DTOs.LendsDTO;
import com.example.pharmapal.entities.Lends;
import com.example.pharmapal.requests.LendsRequest;

import java.util.List;

public interface LendsServiceInterface {

    List<Lends> getLends();

    String addLend(Lends lend);

    String updateLend(LendsDTO lendsDTO);

    String closeLend(LendsRequest lendsRequest);



}
