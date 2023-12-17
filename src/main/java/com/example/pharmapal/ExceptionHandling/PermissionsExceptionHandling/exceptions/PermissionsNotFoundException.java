package com.example.pharmapal.ExceptionHandling.PermissionsExceptionHandling.exceptions;

public class PermissionsNotFoundException extends  RuntimeException{
    public PermissionsNotFoundException(String message) {
        super(message);
    }

    public PermissionsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
