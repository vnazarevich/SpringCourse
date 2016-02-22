package com.epam.spring.club.services;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.spring.club.DAO.DAO;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

public class BookingServiceTest {
	private static BookingService bookingService;
	private static Event event;
	private static DAO dao;
	private static User user;
	private static UserService userService;
	private static EventService eventService;
	
	@BeforeClass
	public static void initialisation() {
		dao = new DAO ();
		bookingService = new BookingService();
		eventService = new EventService();
		eventService.setEvents(dao.getEvents());
		event = eventService.getEventByName("Aerosmith");
		//event = new Event("Aerosmith", "GREEN", new LocalDate(2016,3,7), new LocalTime(19,0,0), 100, 400);
		userService = new UserService();
		userService.setUsers(dao.getUsers());
		user = userService.getUserByName("Sheldon");
		
		
	}
	
	@Test
	public void getTicketPriceTest(){
		assertEquals(100, bookingService.getTicketPrice(event, new LocalDate(2016,3,3), user), 0.000001) ;
	}
	
	@Test
	public void getVipTicketPriceTest(){
		assertEquals(100, bookingService.getVipTicketPrice(event, new LocalDate(2016,3,3), user), 0.000001) ;
	}
	
	@Test
	public void bookTicketTest(){
		assertEquals(2, bookingService.bookTicket(user, event, 2)) ;
	}
}
