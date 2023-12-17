package com.example.pharmapal.ExceptionHandling.PermissionsExceptionHandling;

import com.example.pharmapal.ExceptionHandling.PermissionsExceptionHandling.exceptions.PermissionsNotFoundException;
import com.example.pharmapal.ExceptionHandling.ShiftsExceptionHandling.Exceptions.ShiftAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.ShiftsExceptionHandling.Exceptions.ShiftNotFoundException;
import com.example.pharmapal.ExceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class PermissionsExceptionHandlingController {

    @ExceptionHandler(value =  PermissionsNotFoundException.class)
    public ResponseEntity<Object> PermissionsDoNotExist(PermissionsNotFoundException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

}
