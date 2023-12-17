package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.Entities.TherapeuticClass;
import com.example.pharmapal.Requests.SupplierIdRequest;
import com.example.pharmapal.Requests.TClassRequest;

import java.util.List;

public interface TherapeuticClassServiceInterface {


    public List<TherapeuticClass> getTClasses();
    public String addTClass(TherapeuticClass therapeuticClass);

    public String updateTClass(TherapeuticClassDTO therapeuticClassDTO);
    public String deleteTClass(TClassRequest tClassRequest);
}
