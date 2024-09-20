package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DAOs.TopSoldClasses;
import com.example.pharmapal.entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.entities.TherapeuticClass;
import com.example.pharmapal.requests.TClassRequest;

import java.util.List;

public interface TherapeuticClassServiceInterface {


    public List<TherapeuticClass> getTClasses();
    public String addTClass(TherapeuticClass therapeuticClass);

    public String updateTClass(TherapeuticClassDTO therapeuticClassDTO);
    public String deleteTClass(TClassRequest tClassRequest);

    List<TopSoldClasses> getSalesByClass();
}
