package com.epam.spring.club.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Show {
    private String showId;
    private String eventId;
    private Date date;
    private String auditoriumId;

    public Show(String showId, String eventId, String auditorium, Date date) {
        this.showId = showId;
        this.eventId = eventId;
        this.date = date;
        this.auditoriumId = auditorium;
    }   

    public String getEventId() {
		return eventId;
	}



	public void setEventId(String eventId) {
		this.eventId = eventId;
	}



	public String getAuditoriumId() {
		return auditoriumId;
	}



	public void setAuditoriumId(String auditoriumId) {
		this.auditoriumId = auditoriumId;
	}



	public void setShowId(String showId) {
		this.showId = showId;
	}



	public String getShowId() {
        return showId;
    }

    public String getEvent() {
        return eventId;
    }

    public Date getDate() {
        return date;
    }

    public String getAuditorium() {
        return auditoriumId;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return "Show{" +
                "showId='" + showId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", date=" + dateFormat.format(date) +
                ", auditoriumId='" + auditoriumId + '\'' +
                '}';
    }
}
