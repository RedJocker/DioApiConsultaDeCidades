package org.dioproject.citiesapi.cities.exceptionhandlers;

import org.dioproject.citiesapi.cities.exeptions.CityIdNotFoundException;
import org.dioproject.citiesapi.countries.exeptions.CountryIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class CityExceptionHandler {

    @ExceptionHandler(CityIdNotFoundException.class)
    public ResponseEntity<?> handleIdNotFound(CityIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }
}
