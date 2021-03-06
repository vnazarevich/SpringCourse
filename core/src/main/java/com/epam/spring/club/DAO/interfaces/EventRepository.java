package com.epam.spring.club.DAO.interfaces;

import java.util.List;

import com.epam.spring.club.EventRate;
import com.epam.spring.club.models.Event;

public interface EventRepository {
    Event createEvent(String eventName, int bacePrice, EventRate reat);
    Event remove(Event event);
    Event getByName(String eventName);
    List<Event> getAll();
}
