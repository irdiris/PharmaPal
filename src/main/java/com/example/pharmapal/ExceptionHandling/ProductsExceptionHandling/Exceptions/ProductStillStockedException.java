package com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions;

public class ProductStillStockedException extends RuntimeException{

    public ProductStillStockedException(String message) {
        super(message);
    }

    public ProductStillStockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
