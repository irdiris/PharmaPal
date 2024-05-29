package com.example.pharmapal.services;

import com.example.pharmapal.entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.entities.Mappers.TherapeuticClassMapper;
import com.example.pharmapal.entities.TherapeuticClass;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassNotFound;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassStillReferencedByProducts;
import com.example.pharmapal.interfaces.TherapeuticClassServiceInterface;
import com.example.pharmapal.repositories.TherapeuticClassRepository;
import com.example.pharmapal.requests.TClassRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TherapeuticClassService implements TherapeuticClassServiceInterface {

    private final TherapeuticClassRepository therapeuticClassRepository;

    private final TherapeuticClassMapper therapeuticClassMapper;
    @Autowired

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

