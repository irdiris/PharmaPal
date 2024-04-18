package com.example.pharmapal.ExceptionHandling.StockedProductsExceptionHandling;

import com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions.StaffAlreadyAssignedToShift;
import com.example.pharmapal.ExceptionHandling.StockedProductsExceptionHandling.Exceptions.ExpirationDateOutOfRange;
import com.example.pharmapal.ExceptionHandling.StockedProductsExceptionHandling.Exceptions.ProductIsNotStocked;
import com.example.pharmapal.ExceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
public class StockedProductsExceptionHandlingController {

    @ExceptionHandler(value = ProductIsNotStocked.class)
    public ResponseEntity<Object> ProductIsNotStocked (ProductIsNotStocked e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ExpirationDateOutOfRange.class)
    public ResponseEntity<Object> ExpirationDateOutOfRange(ExpirationDateOutOfRange e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
}
