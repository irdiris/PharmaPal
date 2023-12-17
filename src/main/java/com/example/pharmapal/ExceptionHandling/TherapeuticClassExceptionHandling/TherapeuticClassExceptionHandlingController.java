package com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling;

import com.example.pharmapal.ExceptionHandling.SuppliersExceptionHandling.Exceptions.SupplierAlreadyExists;
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
public class TherapeuticClassExceptionHandlingController {
    @ExceptionHandler(value = TClassNameAlreadyRegistered.class)
    public ResponseEntity<Object> TClassNameAlreadyRegistered (TClassNameAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TClassDescriptionAlreadyRegistered.class)
    public ResponseEntity<Object> TClassNameAlreadyRegistered (TClassDescriptionAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TClassStillReferencedByProducts.class)
    public ResponseEntity<Object> CLassStillReferencedByProduct (TClassStillReferencedByProducts e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }



}
