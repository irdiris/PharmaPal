package com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling;

import com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions.AdministrationTypeDescriptionAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions.AdministrationTypeNameAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions.AdministrationTypeNotFound;
import com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions.AdministrationTypeStillReferencedByProducts;
import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AdministrationTypeExceptionHandlingController {
    @ExceptionHandler(value = AdministrationTypeNameAlreadyRegistered.class)
    public ResponseEntity<Object> AdministrationTypeNameAlreadyRegistered (AdministrationTypeNameAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AdministrationTypeDescriptionAlreadyRegistered.class)
    public ResponseEntity<Object> AdministrationTypeDescriptionAlreadyRegistered (AdministrationTypeDescriptionAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AdministrationTypeNotFound.class)
    public ResponseEntity<Object> AdministrationTypeNotFound (AdministrationTypeNotFound e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AdministrationTypeStillReferencedByProducts.class)
    public ResponseEntity<Object> AdministrationTypeStillReferenced (AdministrationTypeStillReferencedByProducts e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }

}
