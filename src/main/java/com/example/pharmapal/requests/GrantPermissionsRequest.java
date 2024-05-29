package com.example.pharmapal.requests;

import lombok.Data;

@Data
public class GrantPermissionsRequest {


    private Long permissionId;

    private Long staffId;

}
