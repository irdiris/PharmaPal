package com.example.pharmapal.ExceptionHandling.StockedProductsExceptionHandling.Exceptions;

public class ProductIsNotStocked extends  RuntimeException{

    public ProductIsNotStocked(String message) {
        super(message);
    }

    public ProductIsNotStocked(String message, Throwable cause) {
        super(message, cause);
    }
}
