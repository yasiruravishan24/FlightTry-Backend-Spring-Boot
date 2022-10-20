package com.example.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    AirportService airportService;
    @GetMapping(path = "/v1/airports")
    public List<Airport> getAirport() {
        return airportService.getAirport();
    }

    @GetMapping(path = "/v1/airports/code")
    public List<Airport> getAirportByCode(@RequestParam String code) {
        return airportService.getAirportByCode(code);
    }

    @GetMapping(path = "/v1/airports/country")
    public List<Airport> getAirportsByCountry (@RequestParam String country) {
        System.out.print(country);
        return airportService.getAirportsByCountry(country);
    }

    @GetMapping(path = "/v1/airports/name")
    public List<Airport> getAirportByName (@RequestParam String name) {
        return airportService.getAirportsByName(name);
    }
}
