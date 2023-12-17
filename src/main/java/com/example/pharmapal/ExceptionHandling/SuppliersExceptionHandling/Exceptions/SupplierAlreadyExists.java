package com.example.pharmapal.ExceptionHandling.SuppliersExceptionHandling.Exceptions;

public class SupplierAlreadyExists extends  RuntimeException{

    public SupplierAlreadyExists(String message) {
        super(message);
    }

    public SupplierAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }
}
