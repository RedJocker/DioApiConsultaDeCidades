package org.dioproject.citiesapi.distance.services;

import org.dioproject.citiesapi.cities.entities.City;
import org.dioproject.citiesapi.cities.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;


@Service
public class DistanceService {

    private final CityService cityService;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(CityService cityService) {
        this.cityService = cityService;
    }

    public Double distanceByPointsInMiles(final Long cityId1, final Long cityId2) {
        log.info("nativePostgresInMiles({}, {})", cityId1, cityId2);
        return cityService.distanceByPoints(cityId1, cityId2);
    }



    public Double distanceByCubeInMeters(Long cityId1, Long cityId2) {
        log.info("distanceByCubeInMeters({}, {})", cityId1, cityId2);
        City city1 = cityService.findById(cityId1);
        City city2 = cityService.findById(cityId2);

        Point p1 = city1.getLocation();
        Point p2 = city2.getLocation();

        return cityService.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

}
