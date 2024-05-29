package com.example.pharmapal.exceptionHandling.suppliersExceptionHandling.exceptions;

public class SupplierAlreadyExists extends  RuntimeException{

    public SupplierAlreadyExists(String message) {
        super(message);
    }

    public SupplierAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }
}
