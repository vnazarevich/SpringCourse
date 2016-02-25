package com.epam.spring.club.models;

import com.epam.spring.club.EventRate;

public class Event {
    private String eventId;
    private String name;
    private Integer bacePrice;
    private EventRate rate;

    public Event(String name, int bacePrice, EventRate rate){
        this.name = name;
        this.bacePrice = bacePrice;
        this.rate = rate;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public int getBacePrice() {
        return bacePrice;
    }

    public EventRate getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", bacePrice=" + bacePrice +
                ", rate=" + rate +
                '}';
    }
}
