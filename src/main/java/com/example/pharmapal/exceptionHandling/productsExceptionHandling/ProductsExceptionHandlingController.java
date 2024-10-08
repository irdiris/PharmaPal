package com.example.pharmapal.exceptionHandling.productsExceptionHandling;

import com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions.ProductNameIsAlreadyRegisteredException;
import com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions.ProductNotFoundException;
import com.example.pharmapal.exceptionHandling.productsExceptionHandling.exceptions.ProductStillStockedException;
import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice

public class ProductsExceptionHandlingController {

    @ExceptionHandler(value = ProductNameIsAlreadyRegisteredException.class)
    public ResponseEntity<Object> productNameAlreadyRegistered (ProductNameIsAlreadyRegisteredException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> productNotFound(ProductNotFoundException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ProductStillStockedException.class)
    public ResponseEntity<Object> productStillStocked (ProductStillStockedException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.CONFLICT);
    }
}
