package com.example.pharmapal.exceptionHandling.staffExceptionsHandling;

import com.example.pharmapal.exceptionHandling.staffExceptionsHandling.exceptions.StaffMemberAlreadyExistsException;
import com.example.pharmapal.exceptionHandling.staffExceptionsHandling.exceptions.StaffMemberNotFoundException;
import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class StaffExceptionHandlingController {
    @ExceptionHandler(value = StaffMemberAlreadyExistsException.class)
    public ResponseEntity<Object> StaffMemberAlreadyExists (StaffMemberAlreadyExistsException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler ( value = StaffMemberNotFoundException.class)
    public ResponseEntity<Object> StaffMemberNotFound(StaffMemberNotFoundException e){

        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
}
