package com.example.airport;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {
    private List<Airport> airports;
    public AirportService() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/java/com/example/airport/data/airports.json"));
            TypeReference<List<Airport>> typeReference = new TypeReference<List<Airport>>() {};
            airports = mapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Airport> getAirport()  {
        int count=0;
        for (Airport airport: airports) {
            count++;
        }
        return airports;
    }

    public  List<Airport> getAirportByCode(String code) {
        List<Airport> code_airports = new ArrayList<Airport>();
        for (Airport airport: airports) {
            if(airport.getIata_code().replaceAll("\\s+","").toLowerCase().equals(code.replaceAll("\\s+","").toLowerCase())) {
                code_airports.add(airport);
                break;
            }
        }
        return code_airports;
    }

    public List<Airport> getAirportsByCountry(String country) {
        List<Airport> country_airports = new ArrayList<Airport>();
        for (Airport airport: airports) {
            if(airport.getCountry().replaceAll("\\s+","").toLowerCase().equals(country.replaceAll("\\s+","").toLowerCase())) {
                country_airports.add(airport);
            }
        }
        return country_airports;
    }

    public List<Airport> getAirportsByName(String name) {
        List<Airport> name_airports = new ArrayList<Airport>();
        for(Airport airport: airports) {
            if(airport.getName().replaceAll("\\s+","").toLowerCase().equals(name.replaceAll("\\s+","").toLowerCase())) {
                name_airports.clear();
                name_airports.add(airport);
                break;
            }
            else {
                int c = 0;
                Airport add_airport = null;
                while (c < airport.getName().length() && c < name.length()) {
                    if (airport.getName().charAt(c) == name.charAt(c)) add_airport=airport;
                    else {
                        add_airport=null;
                        break;
                    }
                    c++;
                }
                if(add_airport!=null) name_airports.add(add_airport);
            }
        }
        return name_airports;
    }
}
