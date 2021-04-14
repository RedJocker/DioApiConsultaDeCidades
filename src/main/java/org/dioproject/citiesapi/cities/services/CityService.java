package org.dioproject.citiesapi.cities.services;

import org.dioproject.citiesapi.cities.entities.City;
import org.dioproject.citiesapi.cities.exeptions.CityIdNotFoundException;
import org.dioproject.citiesapi.cities.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;



@Service
public class CityService {

    private final String cityIdNotFoundMessageTemplate = "City with id %d was not found";
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page<City> findAll(Pageable page) {
        return cityRepository.findAll(page);
    }

    public City findById(Long id) {

        return cityRepository.findById(id)
                .orElseThrow(() ->
                        new CityIdNotFoundException(String.format(cityIdNotFoundMessageTemplate, id))
                );
    }

    public Double distanceByPoints(Long cityId1, Long cityId2) {
        String location1 = cityRepository.findGeolocationById(cityId1).orElseThrow(() ->
                        new CityIdNotFoundException(String.format(cityIdNotFoundMessageTemplate, cityId1))
                );
        String location2 = cityRepository.findGeolocationById(cityId2).orElseThrow(() ->
                new CityIdNotFoundException(String.format(cityIdNotFoundMessageTemplate, cityId2))
        );
        return cityRepository.distanceByPoints(location1, location2);
    }

    public Double distanceByCube(double x1, double y1, double x2, double y2) {
        return cityRepository.distanceByCube(x1, y1, x2, y2);
    }
}
