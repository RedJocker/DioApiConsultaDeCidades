package org.dioproject.citiesapi.countries.exceptionhandlers;

import org.dioproject.citiesapi.countries.exeptions.CountryIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class CountryExceptionHandler {

    @ExceptionHandler(CountryIdNotFoundException.class)
    public ResponseEntity<?> handleIdNotFound(CountryIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }
}
