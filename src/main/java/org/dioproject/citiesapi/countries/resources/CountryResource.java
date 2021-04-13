package org.dioproject.citiesapi.countries.resources;

import org.dioproject.citiesapi.countries.entities.Country;
import org.dioproject.citiesapi.countries.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<Country> countries() {
        return countryService.findAll();
    }
}


