package com.example.flight;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FlightService {

    static final String AIR_PORT_URL = "http://127.0.0.1:8080/v1/airports";
    static final String API_USER_URL = "http://127.0.0.1:8081/v1/api-users";


    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SegmentRepository segmentRepository;

    @Autowired
    private RestTemplate restTemplate;



    public ResponseData getAllFlightsApiUsers(String apikey, String host) {

        ResponseData res = new ResponseData();

        verifyApiUser(apikey, host, res);

        if(res.getStatus_code() == 200) {
            res.setData(flightRepository.findAll());
        }

        return res;
    }

    public ResponseData getFlightsApiUsers(String apikey, String host, int id) {
        ResponseData res = new ResponseData();

        verifyApiUser(apikey, host, res);

        if(res.getStatus_code() == 200) {
            Optional<Flight> flight = flightRepository.findById(id);

            List<Optional> flights = new ArrayList<>();

            if(flight.isPresent()) {
                flights.add(flight);
            }

            res.setData(flights);
        }

        return res;
    }

    public Optional<Flight> getFlightById(int id) {
        return flightRepository.findById(id);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight createFlight(Flight flight) {

        flight.setFlight_status(true);
        return flightRepository.save(flight);
    }

    public Flight updateFlight(int id, Flight flight) {
        Optional<Flight> currentFlight = flightRepository.findById(id);


        if(currentFlight.isPresent()) {

            currentFlight.get().setAircraft_iata(flight.getAircraft_iata());

            currentFlight.get().setAirline_iata(flight.getAirline_iata());

            currentFlight.get().setAirline_name(flight.getAirline_name());

            currentFlight.get().setFlight_date(flight.getFlight_date());

            currentFlight.get().setFlight_status(flight.isFlight_status());

            currentFlight.get().setSegments(flight.getSegments());

            flightRepository.save(currentFlight.get());
        }


        return currentFlight.orElse(null) ;
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }


    //get All Airports
    public  ResponseData getAllAirports(String apikey, String host) {

        ResponseData res = new ResponseData();

        verifyApiUser(apikey, host, res);

        if(res.getStatus_code() == 200) {
           res.setData(getAllAirPorts());
        }

        return res;
    }

    //get Airport by code
    public  ResponseData getAirportByCode(String apikey, String host, String code) {

        ResponseData res = new ResponseData();

        verifyApiUser(apikey, host, res);

        if(res.getStatus_code() == 200) {
            res.setData(getAirPortByCode(code));
        }

        return res;
    }

    //get Airport by country
    public  ResponseData getAirportByCountry(String apikey, String host, String country) {

        System.out.print(country);
        ResponseData res = new ResponseData();

        verifyApiUser(apikey, host, res);

        if(res.getStatus_code() == 200) {
            res.setData(getAirportByCountry(country));
        }

        return res;
    }

    //get Airport by Name
    public  ResponseData getAirportByName(String apikey, String host, String name) {

        ResponseData res = new ResponseData();

        verifyApiUser(apikey, host, res);

        if(res.getStatus_code() == 200) {
            res.setData(getAirportByName(name));
        }

        return res;
    }


    //verifyApiUser
    private void verifyApiUser(String apikey, String host ,ResponseData res) {
        JSONObject api_user = getApiUser(apikey);

        if(api_user == null) {
            res.setStatus_code(401);
            res.setMessage("An invalid API access key was supplied.");

        }else {
            if (!(api_user.get("host")).equals(host)) {
                res.setStatus_code(400);
                res.setMessage("The host is not valid");
            } else {
                if (!api_user.get("status").equals(true)) {
                    res.setStatus_code(401);
                    res.setMessage("The given API key is inactive.");
                } else {
                    res.setStatus_code(200);
                    res.setMessage("success");
                    updateUsage(api_user);
                }
            }
        }

    }

    //update api usage
    private void updateUsage(JSONObject api_user) {
        int id = (int) (api_user.get("id"));
        updateApiUserUsage(id);
    }


    // Connect api-user microservice
    private JSONObject getApiUser(String apikey) {
        return restTemplate.exchange(API_USER_URL + "/verify-key?apikey=" + apikey, HttpMethod.GET, null, JSONObject.class).getBody();
    }

    //update api-user usage
    private void updateApiUserUsage(int id) {
        restTemplate.exchange(API_USER_URL + "/usage/" + id, HttpMethod.PUT, null, JSONObject.class).getBody();
    }

    private List getAllAirPorts() {
        return restTemplate.exchange(AIR_PORT_URL, HttpMethod.GET, null, List.class).getBody();
    }

    private List getAirPortByCode(String code) {
        return restTemplate.exchange(AIR_PORT_URL + "/code?code=" + code, HttpMethod.GET, null, List.class).getBody();
    }

    private List getAirportByCountry(String county) {
        return restTemplate.exchange(AIR_PORT_URL + "/country?country=" + county, HttpMethod.GET, null, List.class).getBody();
    }

    private List getAirportByName(String name) {
        return restTemplate.exchange(AIR_PORT_URL + "/name?name=" + name, HttpMethod.GET, null, List.class).getBody();
    }

}
