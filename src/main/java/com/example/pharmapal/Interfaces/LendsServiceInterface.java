package com.example.pharmapal.Interfaces;


import com.example.pharmapal.Entities.DTOs.LendsDTO;
import com.example.pharmapal.Entities.Lends;
import com.example.pharmapal.Requests.LendsRequest;

import java.util.List;

public interface LendsServiceInterface {

    List<Lends> getLends();

    String addLend(Lends lend);

    String updateLend(LendsDTO lendsDTO);

    String closeLend(LendsRequest lendsRequest);



}
