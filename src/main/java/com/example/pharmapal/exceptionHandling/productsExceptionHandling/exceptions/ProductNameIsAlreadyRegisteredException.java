package com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions;

public class ProductNameIsAlreadyRegisteredException extends RuntimeException{
    public ProductNameIsAlreadyRegisteredException(String message) {
        super(message);
    }

    public ProductNameIsAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
