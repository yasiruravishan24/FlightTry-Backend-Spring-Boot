package com.example.flight;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "segments")
public class Segment extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "airport")
    private String airport;

    @Column(name = "city")
    private  String city;

    @Column(name = "country")
    private String country;

    @Column(name = "iata")
    private String iata;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @Column(name = "segment_order")
    private int segment_order;

    @Column(name = "segment_type")
    private String segment_type;

    public Segment() {
    }

    public Segment(int id,
                   String airport,
                   String city,
                   String country,
                   String iata,
                   String lat,
                   String lng,
                   int segment_order,
                   String segment_type
    ) {
        this.id = id;
        this.airport = airport;
        this.city = city;
        this.country = country;
        this.iata = iata;
        this.lat = lat;
        this.lng = lng;
        this.segment_order = segment_order;
        this.segment_type = segment_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getSegment_order() {
        return segment_order;
    }

    public void setSegment_order(int segment_order) {
        this.segment_order = segment_order;
    }

    public String getSegment_type() {
        return segment_type;
    }

    public void setSegment_type(String segment_type) {
        this.segment_type = segment_type;
    }
}
