package com.epam.spring.club.models;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.epam.spring.club.services.EventService;

public class Event {
	private String name;
	private LocalDate date;
	private LocalTime time;
	private Auditorium auditorium;
	private int ticketPrice;
	private int vipTicketPrice;
	private EventService eventService;

	//private int freeTickets;
	//private int freeVipTickets;
	// put in properties
	private HashMap<String, Auditorium> auditoriums = new HashMap<String, Auditorium>() {
		{
			put("GREEN", new Auditorium("GREEN", 100, 10));
			put("BlACK", new Auditorium("BlACK", 200, 20));
		}
	};

	
	public Event(String name, Auditorium auditorium, LocalDate date, LocalTime time, int ticketPrice,
			int vipTicketPrice) {
		super();
		this.name = name;
		this.date = date;
		this.time = time;
		this.auditorium = auditorium;
		this.ticketPrice = ticketPrice;
		this.vipTicketPrice = vipTicketPrice;
		//eventService.addEvent(this);
	}
	
	public Event(String name, String auditoriumName, LocalDate date, LocalTime time, int ticketPrice,
			int vipTicketPrice) {
		super();
		this.name = name;
		this.date = date;
		this.time = time;
		this.auditorium = auditoriums.get(auditoriumName);
		this.ticketPrice = ticketPrice;
		this.vipTicketPrice = vipTicketPrice;
		//eventService.addEvent(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getVipTicketPrice() {
		return vipTicketPrice;
	}

	public void setVipTicketPrice(int vipTicketPrice) {
		this.vipTicketPrice = vipTicketPrice;
	}
	
	

/*	
public int getFreeTickets() {
		return freeTickets;
	}

	public void setFreeTickets(int freeTickets) {
		this.freeTickets = freeTickets;
	}

	public int getFreeVipTickets() {
		return freeVipTickets;
	}

	public void setFreeVipTickets(int freeVipTickets) {
		this.freeVipTickets = freeVipTickets;
	}
	*/

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditorium == null) ? 0 : auditorium.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (auditorium == null) {
			if (other.auditorium != null)
				return false;
		} else if (!auditorium.equals(other.auditorium))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", date=" + date + ", auditorium=" + auditorium.getName() + "]";
	}
	public String toStringFullInfo() {
		return "Event [name=" + name + ", date=" + date + ", auditorium=" + auditorium.toString() + "]";
	}

}
