package com.example.pharmapal.ExceptionHandling.SuppliersExceptionHandling;

import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberNotFoundException;
import com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions.ShiftIsNotAssigned;
import com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions.StaffAlreadyAssignedToShift;
import com.example.pharmapal.ExceptionHandling.SuppliersExceptionHandling.Exceptions.SupplierAlreadyExists;
import com.example.pharmapal.ExceptionHandling.ThrownException;
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


}
