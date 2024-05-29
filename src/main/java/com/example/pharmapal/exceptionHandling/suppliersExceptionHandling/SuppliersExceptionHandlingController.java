package com.example.pharmapal.exceptionHandling.suppliersExceptionHandling;

import com.example.pharmapal.exceptionHandling.suppliersExceptionHandling.exceptions.SupplierAlreadyExists;
import com.example.pharmapal.exceptionHandling.ThrownException;
import com.example.pharmapal.exceptionHandling.suppliersExceptionHandling.exceptions.SupplierNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class SuppliersExceptionHandlingController {
    @ExceptionHandler(value = SupplierAlreadyExists.class)
    public ResponseEntity<Object> SupplierAlreadyExistsException (SupplierAlreadyExists e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = SupplierNotFound.class)
    public ResponseEntity<Object> SupplierNotFoundException (SupplierNotFound e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

}
