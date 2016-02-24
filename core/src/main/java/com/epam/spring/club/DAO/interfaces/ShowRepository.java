package com.epam.spring.club.DAO.interfaces;

import java.util.Date;
import java.util.List;

import com.epam.spring.club.models.Auditorium;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;

public interface ShowRepository {
    Show createShow(Event event, Auditorium auditorium, Date date);

    Show getShow(String eventId, String auditoriumId, Date date);

    Show getShow(String showId);

    List<Show> getShowForTheDate(String eventId, Date date);
}
