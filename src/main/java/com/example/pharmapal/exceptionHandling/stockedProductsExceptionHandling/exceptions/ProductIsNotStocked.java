package com.example.pharmapal.exceptionHandling.stockedProductsExceptionHandling.exceptions;

public class ProductIsNotStocked extends  RuntimeException{

    public ProductIsNotStocked(String message) {
        super(message);
    }

    public ProductIsNotStocked(String message, Throwable cause) {
        super(message, cause);
    }
}
