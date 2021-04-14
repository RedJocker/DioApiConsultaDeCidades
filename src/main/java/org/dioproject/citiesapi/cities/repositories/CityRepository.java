package org.dioproject.citiesapi.cities.repositories;


import org.dioproject.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityRepository  extends JpaRepository<City, Long> {

    @Query(value = "SELECT CAST(:geolocation1 as POINT) <@> CAST(:geolocation2 as POINT) as distance", nativeQuery = true)
    Double distanceByPoints(@Param("geolocation1") final String geolocation1, @Param("geolocation2")final String geolocation2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

    @Query(value = "SELECT CAST(lat_lon as TEXT) from cidade WHERE id = :cityId", nativeQuery = true)
    Optional<String> findGeolocationById(@Param("cityId") Long id);
}
