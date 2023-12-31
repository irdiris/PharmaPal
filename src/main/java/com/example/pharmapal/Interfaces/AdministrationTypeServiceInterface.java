package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.AdministrationType;
import com.example.pharmapal.Entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.Requests.AdministrationTypeRequest;

import java.util.List;

public interface AdministrationTypeServiceInterface {

    public List<AdministrationType> getAdministrationType();

    public String addAdministrationType(AdministrationType administrationType);

    public String updateAdministrationType(AdministrationTypeDTO administrationTypeDTO);

    public String deleteAdministrationType(AdministrationTypeRequest administrationTypeRequest);
}
