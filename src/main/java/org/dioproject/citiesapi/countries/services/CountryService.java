package org.dioproject.citiesapi.countries.services;

import org.dioproject.citiesapi.countries.entities.Country;
import org.dioproject.citiesapi.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CountryService {


    final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;

    }

    public Page<Country> findAll(Pageable page) {
        return countryRepository.findAll(page);
    }




}
