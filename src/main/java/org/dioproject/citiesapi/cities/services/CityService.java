package org.dioproject.citiesapi.cities.services;

import org.dioproject.citiesapi.cities.entities.City;
import org.dioproject.citiesapi.cities.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page<City> findAll(Pageable page) {
        return cityRepository.findAll(page);
    }
}
