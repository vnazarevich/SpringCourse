package com.epam.spring.club.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.epam.spring.club.models.Event;

public class EventService {
	private static Logger log = Logger.getLogger(EventService.class.getName());
	private HashMap <String, Event> events;
	
	public void showSelectedEvent(String eventName){
		
	}
	
	public Event createEvent(String name, String auditoriumName, LocalDate date, LocalTime time, int ticketPrice, int vipTicketPrice){
		Event event = new Event (name, auditoriumName, date, time, ticketPrice, vipTicketPrice);
		events.put(name, event);
		log.info("create new event " + event.toString()  );
		return event;
	}
	
	public Event removeEvent(String name){
		Event event = events.get(name);
		events.remove(name);
		log.info("remove event " + name );
		return event;
	}	
	
	public ArrayList <Event> getAllEvents(){
		log.info("start getAllEvents(), count = " + events.size() + " events" );
		return new ArrayList(events.values());
	}
	
	public Event getEventByName(String name){
		Event event = events.get(name);
		//log.info("get event " + event.toString() +" by name" );
		return event;
	}

	public HashMap<String, Event> getEvents() {
		return events;
	}



	public void setEvents(HashMap<String, Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		events.put(event.getName(), event);
		log.info("add new event "+ event.toString());
		
	}
	

}
