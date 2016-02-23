package com.epam.spring.club;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.services.BookingService;
import com.epam.spring.club.services.DiscountService;
import com.epam.spring.club.services.EventService;
import com.epam.spring.club.services.UserService;

public class ClubManager {
	
	//Session imitation
	public static User currentUser;
	private static DiscountService discountService;
	private static BookingService bookingService;
	private static EventService eventService;
	private static UserService userService;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ClubManager manager = (ClubManager) ctx.getBean("clubManager");

		User user = new User("Sunreis", "1234", "sun@gmail.com", new LocalDate(1988, 12, 5));
		Event event = new Event("Aerosmith", "GREEN", new LocalDate(2016,3,7), new LocalTime(19,0,0), 100, 400);
		userService.registration(user.getName(), user.getPass(), user.getMail(), user.getBirthDay());

		//Check DiscountService
		/*
		System.out.println(discountService.getDiscountStrategiesList());
		double discount = discountService.getDiscount(user, event, new LocalDate(2016, 3, 2));
		
		user.setNumberOfPurchasedTickets(9);
		discount = discountService.getDiscount(user, event, new LocalDate(2016, 3, 2));		
		*/
		
		//Check BookingService
		bookingService.getTicketPrice(event, new LocalDate(2016,3,3), user) ;
		bookingService.getVipTicketPrice(event, new LocalDate(2016,3,3), user);
		bookingService.bookTicket(user, event, 2);
		
	}

	public DiscountService getDiscountService() {
		return discountService;
	}

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}

	public static BookingService getBookingService() {
		return bookingService;
	}

	public static void setBookingService(BookingService bookingService) {
		ClubManager.bookingService = bookingService;
	}

	public static EventService getEventService() {
		return eventService;
	}

	public static void setEventService(EventService eventService) {
		ClubManager.eventService = eventService;
	}

	public static UserService getUserService() {
		return userService;
	}

	public static void setUserService(UserService userService) {
		ClubManager.userService = userService;
	}
	
	
}
