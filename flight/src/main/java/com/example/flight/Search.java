package com.example.flight;

import java.time.LocalDate;

public class Search {
    private String departure;
    private String arrival;
    private LocalDate date;

    public Search(String departure, String arrival, LocalDate date) {
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
