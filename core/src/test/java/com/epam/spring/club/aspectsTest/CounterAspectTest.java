package com.epam.spring.club.aspectsTest;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.aspects.CounterAspect;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.services.BookingService;
import com.epam.spring.club.services.EventService;
import com.epam.spring.club.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CounterAspectTest extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private EventService eventService;
	@Autowired
	private CounterAspect counterAspect;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private UserService userService;	
	
	
	@Test
	public void logCallEventByNameTest(){
		eventService.getEventByName("Aerosmith");
		Integer count = counterAspect.getCountersMap().get("Aerosmith").getNumberCallingsByName();	
		eventService.getEventByName("Aerosmith");	
		assertEquals(++count, Integer.valueOf(counterAspect.getCountersMap().get("Aerosmith").getNumberCallingsByName()));
	}
	
	@Test
	public void logEventPriceRequestTest(){
		Event event = eventService.getEventByName("Scorpions");
		User user = userService.getUserByName("Sheldon");
		bookingService.getTicketPrice(event, new LocalDate(2016,4,7), user);;
		Integer count = counterAspect.getCountersMap().get("Scorpions").getNumberOfPriceRequestings();	
		bookingService.getTicketPrice(event, new LocalDate(2018, 10, 8), user);
		assertEquals(++count, Integer.valueOf(counterAspect.getCountersMap().get("Scorpions").getNumberOfPriceRequestings()), 0.00001);
	}
	
	@Test 
	public void bookTicketTest(){
		User user = userService.getUserByName("Sheldon");
		Event event = eventService.getEventByName("Aerosmith");
		bookingService.bookTicket(user, event, 1);
		Integer count = counterAspect.getCountersMap().get("Aerosmith").getNumberOfBookedTickets();	
		bookingService.bookTicket(user, event, 1);
		assertEquals(++count, Integer.valueOf(counterAspect.getCountersMap().get("Aerosmith").getNumberOfBookedTickets()));
	}

}
