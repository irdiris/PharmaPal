package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.Permissions;
import com.example.pharmapal.ExceptionHandling.PermissionsExceptionHandling.exceptions.PermissionsNotFoundException;
import com.example.pharmapal.Interfaces.PermissionsServiceInterface;
import com.example.pharmapal.Repositories.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsService implements PermissionsServiceInterface {

    private final PermissionsRepository permissionsRepository;
@Autowired
    public PermissionsService(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }


    public List<Permissions> getPermissions(){

         List<Permissions> permissionsList = permissionsRepository.findAll();
         if(permissionsList.isEmpty()){
             throw new PermissionsNotFoundException("permissions not found");
         }else {
             return permissionsList;
         }

    }




}
