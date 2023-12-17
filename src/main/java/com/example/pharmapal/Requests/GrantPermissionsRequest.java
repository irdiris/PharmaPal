package com.example.pharmapal.Requests;

import lombok.Data;

@Data
public class GrantPermissionsRequest {


    private Long permissionId;

    private Long staffId;

}
