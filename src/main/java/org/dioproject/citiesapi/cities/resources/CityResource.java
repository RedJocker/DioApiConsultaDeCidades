package org.dioproject.citiesapi.cities.resources;

import org.dioproject.citiesapi.cities.entities.City;
import org.dioproject.citiesapi.cities.services.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public Page<City> cities(Pageable page) {
        return cityService.findAll(page);
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable Long id) {
        return cityService.findById(id);
    }
}
