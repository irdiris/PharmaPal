package com.example.pharmapal.ExceptionHandling.PermissionsExceptionHandling.exceptions;

public class PermissionNotFoundException extends  RuntimeException{
    public PermissionNotFoundException(String message) {
        super(message);
    }

    public PermissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
