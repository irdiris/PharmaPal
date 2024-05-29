package com.example.pharmapal.exceptionHandling.productFormExceptionhandling;

import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormDescriptionAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormNameAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions.ProductFormStillReferencedByProducts;
import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ProductFormExceptionHandlingController {
    @ExceptionHandler(value = ProductFormNameAlreadyRegistered.class)
    public ResponseEntity<Object> productFormNameAlreadyRegistered (ProductFormNameAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProductFormDescriptionAlreadyRegistered.class)
    public ResponseEntity<Object> productFormAlreadyRegistered (ProductFormDescriptionAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProductFormStillReferencedByProducts.class)
    public ResponseEntity<Object> formStillReferencedByProduct (ProductFormStillReferencedByProducts e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }



}
