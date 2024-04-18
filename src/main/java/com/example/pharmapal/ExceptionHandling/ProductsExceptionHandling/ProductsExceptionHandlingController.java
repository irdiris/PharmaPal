package com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling;

import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions.ProductNameIsAlreadyRegisteredException;
import com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions.ProductNotFoundException;
import com.example.pharmapal.ExceptionHandling.ProductsExceptionHandling.Exceptions.ProductStillStockedException;
import com.example.pharmapal.ExceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class ProductsExceptionHandlingController {

    @ExceptionHandler(value = ProductNameIsAlreadyRegisteredException.class)
    public ResponseEntity<Object> productNameAlreadyRegistered (ProductNameIsAlreadyRegisteredException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> productNotFound(ProductNotFoundException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProductStillStockedException.class)
    public ResponseEntity<Object> productStillStocked (ProductStillStockedException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
}
