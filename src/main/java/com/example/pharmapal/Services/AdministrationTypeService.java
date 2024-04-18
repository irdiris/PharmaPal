package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.AdministrationType;
import com.example.pharmapal.Entities.DTOs.AdministrationTypeDTO;
import com.example.pharmapal.Entities.Mappers.AdministrationTypeMapper;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeNotFound;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeStillReferencedByProducts;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNotFound;
import com.example.pharmapal.Interfaces.AdministrationTypeServiceInterface;
import com.example.pharmapal.Repositories.AdministrationTypeRepository;
import com.example.pharmapal.Requests.AdministrationTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministrationTypeService implements AdministrationTypeServiceInterface {


    private final AdministrationTypeRepository administrationTypeRepository;

    public final AdministrationTypeMapper administrationTypeMapper;
    @Autowired

    public AdministrationTypeService(AdministrationTypeRepository administrationTypeRepository, AdministrationTypeMapper administrationTypeMapper) {
        this.administrationTypeRepository = administrationTypeRepository;
        this.administrationTypeMapper = administrationTypeMapper;
    }
    @Override
    public List<AdministrationType> getAdministrationType() {
        return administrationTypeRepository.findAll();
    }

    @Override
    public String addAdministrationType(AdministrationType administrationType) {
        if (!administrationTypeRepository.existsByForm(administrationType.getForm())) {
            if (!administrationTypeRepository.existsByDescription(administrationType.getDescription())) {
                administrationTypeRepository.save(administrationType);
                return "new class registered.";
            } else {
                throw new AdministrationTypeNameAlreadyRegistered("this class is already registered.");
            }
        } else {
            throw new AdministrationTypeDescriptionAlreadyRegistered("this description matches another one that is already registered");
        }

    }

    @Override
    public String updateAdministrationType(AdministrationTypeDTO administrationTypeDTO) {

        AdministrationType preUpdateAdministrationType = administrationTypeRepository.findById(administrationTypeDTO.getId()).orElseThrow(() -> new TClassNotFound("this class is not registered."));
        if (!administrationTypeRepository.existsByForm(preUpdateAdministrationType.getForm())) {
            if (!administrationTypeRepository.existsByDescription(preUpdateAdministrationType.getDescription())) {
                administrationTypeMapper.mapFromDto(administrationTypeDTO, preUpdateAdministrationType);
                 administrationTypeRepository.save(preUpdateAdministrationType);
                return "new class registered.";
            } else {
                throw new TClassNameAlreadyRegistered("this class is already registered.");
            }
        } else {
            throw new TClassDescriptionAlreadyRegistered("this description matches another one that is already registered");
        }

    }

    @Override
    public String deleteAdministrationType(AdministrationTypeRequest administrationTypeRequest) {
        AdministrationType preDeleteAdministrationType = administrationTypeRepository.findById(administrationTypeRequest.getId()).orElseThrow(() -> new AdministrationTypeNotFound("this class is not registered."));
        if (preDeleteAdministrationType.getProductsSet().isEmpty()) {
             administrationTypeRepository.delete(preDeleteAdministrationType);
            return "Class deleted.";
        } else {
            throw new AdministrationTypeStillReferencedByProducts("there are products that still reference this type, delete them or update the reference.");
        }
    }
}
