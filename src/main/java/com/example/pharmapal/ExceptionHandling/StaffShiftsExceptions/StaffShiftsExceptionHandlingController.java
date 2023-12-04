package com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions;

import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberNotFoundException;
import com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions.ShiftIsNotAssigned;
import com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions.StaffAlreadyAssignedToShift;
import com.example.pharmapal.ExceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class StaffShiftsExceptionHandlingController {
    @ExceptionHandler(value = StaffAlreadyAssignedToShift.class)
    public ResponseEntity<Object> StaffAlreadyAssignedToShift (StaffAlreadyAssignedToShift e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ShiftIsNotAssigned.class)
    public ResponseEntity<Object> ShiftIsNotAssigned (ShiftIsNotAssigned e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

}
