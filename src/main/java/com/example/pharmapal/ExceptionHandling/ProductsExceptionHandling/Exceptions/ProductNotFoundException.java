package com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions;

public class ProductNotFoundException extends  RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
