package com.epam.spring.club.DAO.interfaces;

import java.util.Map;

import com.epam.spring.club.models.Event;

public interface CountersRepository {
    void addCountEventRetrievedByName(String eventId);

    void addCountEventRetrivedByBookedTicket(String eventId);

    void addCountEventRetrievedByTicketPrice(String eventId);

    int getCountEventRetrievedByName(Event event);

    int getCountEventRetrievedByTicketPrice(Event event);

    int getCountEventRetrivedByBookedTicket(Event event);

    Map<String, Integer> getAllCountersByName();

    Map<String, Integer> getAllCountersByTicketPrice();

    Map<String, Integer> getAllCountersByBookedTicket();
}
