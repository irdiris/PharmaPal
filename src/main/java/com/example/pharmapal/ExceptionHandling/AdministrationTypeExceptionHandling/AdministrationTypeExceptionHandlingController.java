package com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling;

import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeNotFound;
import com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions.AdministrationTypeStillReferencedByProducts;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions.TClassStillReferencedByProducts;
import com.example.pharmapal.ExceptionHandling.ThrownException;
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
