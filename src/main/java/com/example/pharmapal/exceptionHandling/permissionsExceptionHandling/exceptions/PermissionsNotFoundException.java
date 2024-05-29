package com.example.pharmapal.exceptionHandling.permissionsExceptionHandling.exceptions;

public class PermissionsNotFoundException extends  RuntimeException{
    public PermissionsNotFoundException(String message) {
        super(message);
    }

    public PermissionsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
