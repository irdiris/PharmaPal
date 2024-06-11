package com.example.pharmapal.exceptionHandling.lendsExceptionHandling;

import com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions.LendDoesNotExistException;
import com.example.pharmapal.exceptionHandling.ThrownException;
import com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions.NoProductLeftException;
import com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions.ProductNearlyExpiredException;
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
    @ExceptionHandler(value = ProductNearlyExpiredException.class)
    public ResponseEntity<Object> productNearlyExpired (ProductNearlyExpiredException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NoProductLeftException.class)
    public ResponseEntity<Object> noProductLeft (NoProductLeftException e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

}
