package com.epam.spring.club.aspectsTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.aspects.DiscountAspect;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.services.BookingService;
import com.epam.spring.club.services.EventService;
import com.epam.spring.club.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DiscountAspectTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private EventService eventService;
	@Autowired
	private DiscountAspect discountAspect;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private UserService userService;
	
	private User user;
	private Event event;
	
	
	@Test
	public void countCallsBithdayStrategyTest(){
		user = userService.getUserByName("Sheldon");
		event = eventService.getEventByName("Aerosmith");
		int numberCallsBithdaystrategy = discountAspect.getNumberCallsBithdaystrategy();
		System.out.println(numberCallsBithdaystrategy);
		//disc
		bookingService.getTicketPrice(event, event.getDate(), user);
		System.out.println(discountAspect.getNumberCallsBithdaystrategy());
		assertEquals(++numberCallsBithdaystrategy, discountAspect.getNumberCallsBithdaystrategy());
		
	}

}
