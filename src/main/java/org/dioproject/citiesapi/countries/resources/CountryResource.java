package org.dioproject.citiesapi.countries.resources;

import org.dioproject.citiesapi.countries.entities.Country;
import org.dioproject.citiesapi.countries.services.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public Page<Country> countries(Pageable page) {
        return countryService.findAll(page);
    }

    @GetMapping("/{id}")
    public Country getOne(@PathVariable Long id) {
        return countryService.findById(id);
    }
}


