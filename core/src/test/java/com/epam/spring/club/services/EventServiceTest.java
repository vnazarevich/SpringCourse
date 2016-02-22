package com.epam.spring.club.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.spring.club.models.Event;

public class EventServiceTest {
	private static EventService eventService;
	private static HashMap <String, Event> events = new HashMap <String, Event>(){{
		put ("Aerosmith", new Event("Aerosmith", "GREEN", new LocalDate(2016,3,7), new LocalTime(19,0,0), 100, 200));
		put ("Scorpions", new Event("Scorpions", "BLACK", new LocalDate(2016,4,7), new LocalTime(20,0,0), 120, 200));
	}};
	
	@BeforeClass
	public static void initialisation(){
		eventService = new EventService();
		eventService.setEvents(events);
	}
	
	@Test
	public void getAllEventsTest(){
		assertEquals(new ArrayList(events.values()), eventService.getAllEvents());
	}
	
	@Test
	public void createEventTest(){
		assertEquals("TIK", eventService.createEvent("TIK", "GREEN", new LocalDate(2016, 2, 15), new LocalTime(20, 0, 0), 100, 150).getName());;
	}
	
	@Test
	public void removeEventTest(){
		assertEquals("TIK", eventService.removeEvent("TIK").getName());;
	
		assertEquals("Scorpions", eventService.removeEvent("Scorpions").getName());;
	}
	
	@Test
	public void getEventByNameTest(){
		assertEquals("Aerosmith", eventService.getEventByName("Aerosmith").getName());
	}
	

}
