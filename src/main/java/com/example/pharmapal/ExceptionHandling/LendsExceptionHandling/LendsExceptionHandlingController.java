package com.example.pharmapal.ExceptionHandling.LendsExceptionHandling;

import com.example.pharmapal.ExceptionHandling.LendsExceptionHandling.Exceptions.LendDoesNotExistException;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions.ProductFormStillReferencedByProducts;
import com.example.pharmapal.ExceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class LendsExceptionHandlingController {
    @ExceptionHandler(value = LendDoesNotExistException.class)
    public ResponseEntity<Object> lendDoesNotExist (LendDoesNotExistException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }


}
