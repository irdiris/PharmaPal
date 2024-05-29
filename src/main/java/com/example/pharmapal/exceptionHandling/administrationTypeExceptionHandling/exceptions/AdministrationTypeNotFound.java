package com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions;

public class AdministrationTypeNotFound extends RuntimeException{
    public AdministrationTypeNotFound(String message) {
        super(message);
    }

    public AdministrationTypeNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
