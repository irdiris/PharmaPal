package com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions;

public class ProductStillStockedException extends RuntimeException{

    public ProductStillStockedException(String message) {
        super(message);
    }

    public ProductStillStockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
