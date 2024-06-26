package com.example.pharmapal.exceptionHandling.commandLineExceptionHandling;

import com.example.pharmapal.exceptionHandling.commandLineExceptionHandling.exceptions.PathDoesNotExistException;

import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CommandLineExceptionHandlingController {
    @ExceptionHandler(value = PathDoesNotExistException.class)
    public ResponseEntity<Object> PathDoesNotExist(PathDoesNotExistException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
}
