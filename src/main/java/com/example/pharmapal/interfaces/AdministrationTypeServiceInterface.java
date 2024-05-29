package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.AdministrationType;
import com.example.pharmapal.entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.requests.AdministrationTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdministrationTypeServiceInterface {

    public List<AdministrationType> getAdministrationType();

    public String addAdministrationType(AdministrationType administrationType);

    public String updateAdministrationType(AdministrationTypeDTO administrationTypeDTO);

    public String deleteAdministrationType(AdministrationTypeRequest administrationTypeRequest);
}
