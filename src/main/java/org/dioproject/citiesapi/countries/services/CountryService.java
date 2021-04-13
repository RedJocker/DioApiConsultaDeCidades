package org.dioproject.citiesapi.countries.services;

import org.dioproject.citiesapi.countries.entities.Country;
import org.dioproject.citiesapi.countries.exeptions.CountryIdNotFoundException;
import org.dioproject.citiesapi.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CountryService {


    final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;

    }

    public Page<Country> findAll(Pageable page) {
        return countryRepository.findAll(page);
    }


    public Country findById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() ->
                        new CountryIdNotFoundException(
                                String.format("Country with id %d was not found", id)
                        )
                );
    }
}
