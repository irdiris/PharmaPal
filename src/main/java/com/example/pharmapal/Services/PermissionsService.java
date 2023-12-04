package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.Permissions;
import com.example.pharmapal.Repositories.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsService {

    private final PermissionsRepository permissionsRepository;
@Autowired
    public PermissionsService(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }


    public List<Permissions> getPermissions(){

    return  permissionsRepository.findAll();
    }


}
