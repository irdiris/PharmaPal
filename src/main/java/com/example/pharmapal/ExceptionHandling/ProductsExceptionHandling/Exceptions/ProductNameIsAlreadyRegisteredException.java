package com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions;

public class ProductNameIsAlreadyRegisteredException extends RuntimeException{
    public ProductNameIsAlreadyRegisteredException(String message) {
        super(message);
    }

    public ProductNameIsAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
