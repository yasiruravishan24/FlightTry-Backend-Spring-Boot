package com.example.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // ADMIN

    // get flights
    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/v1/all-flights")
    public List<Flight> getAllApiUsers() {
        return flightService.getAllFlights();
    }

    // get flights by id
    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/v1/flights/{id}")
    public Optional<Flight> getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    // create flight
    @CrossOrigin(origins = "http://localhost:3003")
    @PostMapping ("/v1/flights")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    // update flight
    @CrossOrigin(origins = "http://localhost:3003")
    @PutMapping ("/v1/flights/{id}")
    public Flight createFlight(@PathVariable int id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    // delete flight
    @CrossOrigin(origins = "http://localhost:3003")
    @DeleteMapping ("/v1/flights/{id}")
    public void createFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
    }


    // API USER


    // get All flights for api user
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/v1/flights")
    public ResponseData getAllFlightApiUser(@RequestParam String apikey, @RequestHeader("origin") String host) {

        return flightService.getAllFlightsApiUsers(apikey, host);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/v1/flight/{id}")
    public ResponseData getFlightApiUser(@RequestParam String apikey, @RequestHeader("origin") String host, @PathVariable int id) {

        return flightService.getFlightsApiUsers(apikey, host, id);
    }

    //  get airports
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/v1/airports")
    public ResponseData getAllAirPorts(@RequestParam String apikey, @RequestHeader("origin") String host) {
        return flightService.getAllAirports(apikey, host);
    }

    //  get airport by code
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/v1/airports/code")
    public ResponseData getAirportByCode(@RequestParam String apikey, @RequestParam String code, @RequestHeader("origin") String host) {
        return flightService.getAirportByCode(apikey, host, code);
    }

    //  get airports by country
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/v1/airports/country")
    public ResponseData getAirportByCountry(@RequestParam String apikey, @RequestParam String country, @RequestHeader("origin") String host) {
        return flightService.getAirportByCountry(apikey, host, country);
    }

    //  get airport by name
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/v1/airports/name")
    public ResponseData getAirportByName(@RequestParam String apikey , @RequestParam String name, @RequestHeader("origin") String host) {
        return flightService.getAirportByName(apikey, host, name);
    }

}
