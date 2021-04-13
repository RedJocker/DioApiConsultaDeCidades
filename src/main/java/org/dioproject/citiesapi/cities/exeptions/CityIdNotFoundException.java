package org.dioproject.citiesapi.cities.exeptions;

public class CityIdNotFoundException extends RuntimeException {

    public CityIdNotFoundException(String message) {
        super(message);
    }
}
