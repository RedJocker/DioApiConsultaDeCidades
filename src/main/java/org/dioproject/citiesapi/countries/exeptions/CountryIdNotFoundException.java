package org.dioproject.citiesapi.countries.exeptions;

public class CountryIdNotFoundException extends RuntimeException{

    public CountryIdNotFoundException(String message) {
        super(message);
    }
}
