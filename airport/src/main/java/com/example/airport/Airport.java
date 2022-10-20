package com.example.airport;

public class Airport {
    private String name;
    private String city;
    private String country;
    private String iata_code;
    private GeoLocation _geoloc;
    private int links_count;
    private String objectID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public GeoLocation get_geoloc() {
        return _geoloc;
    }

    public void set_geoloc(GeoLocation _geoloc) {
        this._geoloc = _geoloc;
    }

    public int getLinks_count() {
        return links_count;
    }

    public void setLinks_count(int links_count) {
        this.links_count = links_count;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }
}
