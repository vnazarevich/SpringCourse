package com.epam.spring.club;

import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.club.models.Auditorium;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;
import com.epam.spring.club.models.User;
import com.epam.spring.club.service.AuditoriumService;
import com.epam.spring.club.service.BookingService;
import com.epam.spring.club.service.DiscountService;
import com.epam.spring.club.service.EventService;
import com.epam.spring.club.service.UserService;

public class ClubManager {

	// Session imitation
	public static User currentUser;
	private static DiscountService discountService;
	private static BookingService bookingService;
	private static EventService eventService;
	private static UserService userService;
	public final static Logger logger = Logger.getLogger(ClubManager.class);

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		ClubManager manager = (ClubManager) ctx.getBean("clubManager");
		// create services
		AuditoriumService auditoriumService = ctx.getBean("auditoriumService",
				AuditoriumService.class);
		UserService userService = ctx.getBean("clientService",
				UserService.class);
		EventService eventService = ctx.getBean("eventService",
				EventService.class);
		BookingService bookingService = ctx.getBean("bookingService",
				BookingService.class);
		DiscountService discountService = ctx.getBean("discountService",
				DiscountService.class);
		
		// check userService
		logger.info("Create user Sheldon, sheldon@google.com");
		userService.registerUser("Sheldon", "sheldon@google.com");
		logger.info("Check user:");
		User user = userService.getUsersByName("Sheldon");
		logger.info(user.toString());
		
		//check eventService
		logger.info("Create new event: Armagedon");
		eventService.create("Armagedon", 250, EventRate.HIGH);
		logger.info("Check event Armagedon");
		Event event = eventService.getByName("Armagedon");
		logger.info(event.toString());
		
		//check auditoriumService
		List<Auditorium> auditoriums = auditoriumService.getAuditoriums();
		Auditorium kinopalace;
		Show show = null;
		for (Auditorium auditorium : auditoriums) {
			if (auditorium.getName().equals("Green")) {
				logger.info(auditorium);
				kinopalace = auditorium;
				show = eventService.assignAuditorium(event, kinopalace,
						new GregorianCalendar(2016, 2, 12).getTime());
				break;
			}
		}
		logger.info("Show was created:");
		if (show != null) {
			logger.info(show.toString());
		}

		//check bookingService
		logger.info("Get tiket price for the show:");
		Ticket ticket = bookingService.getTicketPrice(event,
				show.getAuditorium(), show.getDate(), 2, user.getName());
		logger.info(ticket.toString());

		logger.info("Book tiket");
		Ticket bookedTicket = bookingService.bookTicket(user.getName(), ticket);
		logger.info(bookedTicket.toString());

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
