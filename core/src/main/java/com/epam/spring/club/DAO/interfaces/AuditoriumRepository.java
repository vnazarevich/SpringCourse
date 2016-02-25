package com.epam.spring.club.DAO.interfaces;

import java.util.List;

import com.epam.spring.club.models.Auditorium;

public interface AuditoriumRepository {
	
    List<Auditorium> getAuditoriumList();

    Auditorium addAuditorium(String name, int seatsNumber, List<String> vipSeats);
}
