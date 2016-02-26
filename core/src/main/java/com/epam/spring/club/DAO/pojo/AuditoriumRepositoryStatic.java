package com.epam.spring.club.DAO.pojo;


import java.util.List;

import com.epam.spring.club.DAO.interfaces.AuditoriumRepository;
import com.epam.spring.club.models.Auditorium;

public class AuditoriumRepositoryStatic implements AuditoriumRepository {
    private List<Auditorium> auditoriumList;

    public List<Auditorium> getAuditoriumList() {
        return auditoriumList;
    }

    public void setAuditoriumList(List<Auditorium> auditoriumList) {
        this.auditoriumList = auditoriumList;
    }

    public Auditorium addAuditorium(String name, int seatsNumber, List<String> vipSeats){
        Auditorium auditorium = new Auditorium(name, seatsNumber, vipSeats);
        auditoriumList.add(auditorium);
        return auditorium;
    }
}
