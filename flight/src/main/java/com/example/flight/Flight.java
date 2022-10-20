package com.example.flight;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight extends AuditModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "aircraft_iata")
    private String aircraft_iata;

    @Column(name = "airline_iata")
    private String airline_iata;

    @Column(name = "airline_name")
    private String airline_name;

    @Column(name = "flight_date")
    private LocalDate flight_date;

    @Value("${some.key:true}")
    @Column(name = "flight_status")
    private boolean flight_status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "flights_id", referencedColumnName = "id")
    private List<Segment> segments;

    public Flight() {
    }

    public Flight(int id,
                  String aircraft_iata,
                  String airline_iata,
                  String airline_name,
                  LocalDate flight_date,
                  boolean flight_status,
                  List<Segment> segments
    ) {
        this.id = id;
        this.aircraft_iata = aircraft_iata;
        this.airline_iata = airline_iata;
        this.airline_name = airline_name;
        this.flight_date = flight_date;
        this.flight_status = flight_status;
        this.segments = segments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAircraft_iata() {
        return aircraft_iata;
    }

    public void setAircraft_iata(String aircraft_iata) {
        this.aircraft_iata = aircraft_iata;
    }

    public String getAirline_iata() {
        return airline_iata;
    }

    public void setAirline_iata(String airline_iata) {
        this.airline_iata = airline_iata;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public LocalDate getFlight_date() {
        return flight_date;
    }

    public void setFlight_date(LocalDate flight_date) {
        this.flight_date = flight_date;
    }

    public boolean isFlight_status() {
        return flight_status;
    }

    public void setFlight_status(boolean flight_status) {
        this.flight_status = flight_status;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }
}
