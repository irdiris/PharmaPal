package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.Entities.Mappers.TherapeuticClassMapper;
import com.example.pharmapal.Entities.TherapeuticClass;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNotFound;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassStillReferencedByProducts;
import com.example.pharmapal.Interfaces.TherapeuticClassServiceInterface;
import com.example.pharmapal.Repositories.TherapeuticClassRepository;
import com.example.pharmapal.Requests.TClassRequest;

import java.util.List;

public class TherapeuticClassService implements TherapeuticClassServiceInterface {

    private final TherapeuticClassRepository therapeuticClassRepository;

    private final TherapeuticClassMapper therapeuticClassMapper;

    public TherapeuticClassService(TherapeuticClassRepository therapeuticClassRepository, TherapeuticClassMapper therapeuticClassMapper) {
        this.therapeuticClassRepository = therapeuticClassRepository;
        this.therapeuticClassMapper = therapeuticClassMapper;
    }

    @Override
    public List<TherapeuticClass> getTClasses() {
        return therapeuticClassRepository.findAll();
    }

    @Override
    public String addTClass(TherapeuticClass therapeuticClass) {
        if (!therapeuticClassRepository.existsByName(therapeuticClass.getName())) {
            if (!therapeuticClassRepository.existsByDescription(therapeuticClass.getDescription())) {
                therapeuticClassRepository.save(therapeuticClass);
                return "new class registered.";
            } else {
                throw new TClassNameAlreadyRegistered("this class is already registered.");
            }
        } else {
            throw new TClassDescriptionAlreadyRegistered("this description matches another one that is already registered");
        }

    }

    @Override
    public String updateTClass(TherapeuticClassDTO therapeuticClassDTO) {

        TherapeuticClass preUpdatetherapeuticClass = therapeuticClassRepository.findById(therapeuticClassDTO.getId()).orElseThrow(() -> new TClassNotFound("this class is not registered."));
        if (!therapeuticClassRepository.existsByName(preUpdatetherapeuticClass.getName())) {
            if (!therapeuticClassRepository.existsByDescription(preUpdatetherapeuticClass.getDescription())) {
                therapeuticClassMapper.mapFromDto(therapeuticClassDTO, preUpdatetherapeuticClass);
                therapeuticClassRepository.save(preUpdatetherapeuticClass);
                return "new class registered.";
            } else {
                throw new TClassNameAlreadyRegistered("this class is already registered.");
            }
        } else {
            throw new TClassDescriptionAlreadyRegistered("this description matches another one that is already registered");
        }

    }

    @Override
    public String deleteTClass(TClassRequest tClassRequest) {
        TherapeuticClass preDeletetherapeuticClass = therapeuticClassRepository.findById(tClassRequest.getId()).orElseThrow(() -> new TClassNotFound("this class is not registered."));
        if (preDeletetherapeuticClass.getProductsSet().isEmpty()) {
            therapeuticClassRepository.delete(preDeletetherapeuticClass);
            return "Class deleted.";
        } else {
            throw new TClassStillReferencedByProducts("there are products that still reference this class, delete them or update the reference.");
        }
    }
}

