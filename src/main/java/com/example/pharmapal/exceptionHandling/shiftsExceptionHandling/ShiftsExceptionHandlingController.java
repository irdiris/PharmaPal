package com.example.pharmapal.exceptionHandling.shiftsExceptionHandling;

import com.example.pharmapal.exceptionHandling.shiftsExceptionHandling.exceptions.ShiftAlreadyExistsException;
import com.example.pharmapal.exceptionHandling.shiftsExceptionHandling.exceptions.ShiftNotFoundException;
import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ShiftsExceptionHandlingController {
    @ExceptionHandler(value = ShiftAlreadyExistsException.class)
    public ResponseEntity<Object> ShiftAlreadyExists(ShiftAlreadyExistsException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value =  ShiftNotFoundException.class)
    public ResponseEntity<Object> ShiftDoesNotExist(ShiftNotFoundException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

}
