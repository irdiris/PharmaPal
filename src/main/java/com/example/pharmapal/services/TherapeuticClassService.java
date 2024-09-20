package com.example.pharmapal.services;

import com.example.pharmapal.entities.DAOs.TopSoldClasses;
import com.example.pharmapal.entities.DTOs.TherapeuticClassDTO;
import com.example.pharmapal.entities.mappers.TherapeuticClassMapper;
import com.example.pharmapal.entities.TherapeuticClass;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassNotFound;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassStillReferencedByProducts;
import com.example.pharmapal.interfaces.TherapeuticClassServiceInterface;
import com.example.pharmapal.repositories.ProductsRepository;
import com.example.pharmapal.repositories.TherapeuticClassRepository;
import com.example.pharmapal.requests.TClassRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapeuticClassService implements TherapeuticClassServiceInterface {

    private final TherapeuticClassRepository therapeuticClassRepository;

    private final TherapeuticClassMapper therapeuticClassMapper;
    private final ProductsRepository productsRepository;
    @Autowired

    public TherapeuticClassService(TherapeuticClassRepository therapeuticClassRepository, TherapeuticClassMapper therapeuticClassMapper, ProductsRepository productsRepository) {
        this.therapeuticClassRepository = therapeuticClassRepository;
        this.therapeuticClassMapper = therapeuticClassMapper;
        this.productsRepository = productsRepository;
    }

    @Override
    public List<TherapeuticClass> getTClasses() {
        List<TherapeuticClass> therapeuticClasses =  therapeuticClassRepository.findAll();
        for (TherapeuticClass therapeuticClass: therapeuticClasses){
            therapeuticClass.setProductsSet(productsRepository.findAllByTherapeuticClass(therapeuticClass));
        }
        System.out.println(therapeuticClasses);
        return therapeuticClasses;
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

    @Override
    public List<TopSoldClasses> getSalesByClass(){
        List<Object[]> objects = therapeuticClassRepository.getSalesByClass();
     return  objects.stream().map(
                object -> new TopSoldClasses(
                        (String) object[0],
                        (String) object[1],
                        Math.toIntExact((Long) object[2]),
                        Math.toIntExact((Long) object[3])
                ))
        .toList();
    }
}