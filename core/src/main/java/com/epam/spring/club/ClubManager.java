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
	
	//Session imitation
	public static User currentUser;
	private static DiscountService discountService;
	private static BookingService bookingService;
	private static EventService eventService;
	private static UserService userService;
	public final static Logger logger = Logger.getLogger(ClubManager.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ClubManager manager = (ClubManager) ctx.getBean("clubManager");
		//create services
        AuditoriumService auditoriumService = ctx.getBean("auditoriumService", AuditoriumService.class);
        UserService userService = ctx.getBean("clientService", UserService.class);
        EventService eventService = ctx.getBean("eventService", EventService.class);
        BookingService bookingService = ctx.getBean("bookingService", BookingService.class);
        DiscountService discountService = ctx.getBean("discountService", DiscountService.class);

//        logger.info("Register user Sheldon, sheldon@google.com");
//        userService.registerUser("Sheldon", "sheldon@google.com");
//
//        logger.info("Check user:");
//        User user = userService.getUserByName("Sheldon");
//        logger.info(user.toString());
//
//        logger.info("Create event: Star Wars with base price 250.00");
//        eventService.createEvent("Star Wars", 250, EventRate.HIGH);
//        
//        logger.info("Check if event was created:");
//        Event event = eventService.getEventByName("Star Wars");
//        logger.info(event.toString());
//
//        logger.info("Assigne auditorium");
//        List<Auditorium> auditoriums = auditoriumService.getAuditoriums();
//        Auditorium kinopalace;
//        Show show = null;
//
//        for(Auditorium auditorium : auditoriums){
//            if(auditorium.getName().equals("Kinopalace")){
//                logger.info(auditorium);
//                kinopalace = auditorium;
//                show = eventService.assignAuditorium(event, kinopalace, new GregorianCalendar(2016, 2, 12).getTime());
//                break;
//            }
//        }
//
//        logger.info("Show was created:");
//        if (show != null) {
//            logger.info(show.toString());
//        }
//
//        logger.info("Get tiket price for the show:");
//        Ticket ticket = bookingService.getTicketPrice(event, show.getAuditorium(), show.getDate(), 2, user.getName());
//        logger.info(ticket.toString());
//
//        logger.info("Book tiket");
//        Ticket bookedTicket = bookingService.bookTicket(user.getName(), ticket);
//        logger.info(bookedTicket.toString());

        //System.out.println("Aspect - " + discountService.getDiscountStatisticsByUser(user));
       // String discount = discountService.getDiscount(user, event.getName(), new GregorianCalendar(2016, 2, 12).getTime());
      //  logger.info("You got discount " + discount + "%");
        //System.out.println("Aspect - " + discountService.getDiscountStatisticsByUser(user));


        logger.info("Get all tikets for the user");
       // List<String> ticketList = userService.getBookedTickets(user);
    //    logger.info(ticketList);
    
}


//		User user = new User("Sunreis", "1234", "sun@gmail.com", new LocalDate(1988, 12, 5));
//		Event event = new Event("Aerosmith", "GREEN", new LocalDate(2016,3,7), new LocalTime(19,0,0), 100, 400);
//		userService.registration(user.getName(), user.getPass(), user.getMail(), user.getBirthDay());

		//Check DiscountService
		/*
		System.out.println(discountService.getDiscountStrategiesList());
		double discount = discountService.getDiscount(user, event, new LocalDate(2016, 3, 2));
		
		user.setNumberOfPurchasedTickets(9);
		discount = discountService.getDiscount(user, event, new LocalDate(2016, 3, 2));		
		*/
		
		//Check BookingService
//		User user = userService.getUserByName("Sheldon");
//		Event event = eventService.getEventByName("Aerosmith");
		//bookingService.getTicketPrice(event, new LocalDate(2016,3,3), user) ;
//		bookingService.getVipTicketPrice(event, new LocalDate(2016,3,3), user);
//		bookingService.bookTicket(user, event, 2);
		
//	}

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
