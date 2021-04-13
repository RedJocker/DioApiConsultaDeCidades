package org.dioproject.citiesapi.countries.repositories;


import org.dioproject.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
