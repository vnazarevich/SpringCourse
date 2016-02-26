package com.epam.spring.club.service;

import java.util.Date;
import java.util.logging.Logger;

import org.joda.time.LocalDate;

import com.epam.spring.club.DAO.interfaces.ClientTicketRepository;
import com.epam.spring.club.DAO.interfaces.CountersRepository;
import com.epam.spring.club.DAO.interfaces.ShowRepository;
import com.epam.spring.club.DAO.interfaces.TicketRepository;
import com.epam.spring.club.DAO.interfaces.UserRepository;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;
import com.epam.spring.club.models.User;

public class BookingService {
	private static Logger log = Logger.getLogger(BookingService.class.getName());
	private DiscountService discountService;
	private EventService eventService;
    private TicketRepository ticketRepository;
    private ClientTicketRepository clientTicketRepository;
    private UserRepository clientRepository;
    private ShowRepository showRepository;
    private CountersRepository countersRepository;
	
    public Ticket getTicketPrice(Event event, String auditoriumId, Date date, int seat, String userName){
        Show show = showRepository.getShow(event.getEventId(), auditoriumId, date);
        return ticketRepository.getTicket(show.getShowId(), seat);
    }
	
	public double getVipTicketPrice(Event event, LocalDate date, User user){
//		double price;
//		price = eventService.getEventByName(event.getName()).getVipTicketPrice();
//		System.out.println(price);
//		price = price*(1 - discountService.getDiscount(user, event, date));
//		log.info("return price for ticket = " + price);
//		return price;
		return 0.1;
	}
	
	/*
	 * return false if user is not registered
	 * else book ticket and return true
	 */
	public boolean bookTicket(User user, Event event, int count){
		if (null == user){
			log.info("User is anonimus");
			return false;
		}
		// check free places
		//int freePlaces = event.getAuditorium().getFreePlaceCount();
		int freePlaces = 100;
		if(freePlaces >= count){
			user.setBookTickets(event, count);
			//event.getAuditorium().setFreePlaceCount(freePlaces + count);		
			log.info("User" + user.getName() + "has booked " + count + " tickets on " + event.getName());
			
		} else {
			log.info("There are not enough places");
		}
		return true;
	}
	
	public Ticket bookTicket(String userName, Ticket ticket){
        User user = clientRepository.getUserByName(userName);

        if(user != null){
            clientTicketRepository.addTicket(new String(""+user.getId()), ticket.getTicketId());
        }
        return ticketRepository.bookTiket(ticket.getTicketId());
    }
	
	public DiscountService getDiscountService() {
		return discountService;
	}

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setTicketRepository(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public void setClientTicketRepository(
			ClientTicketRepository clientTicketRepository) {
		this.clientTicketRepository = clientTicketRepository;
	}

	public void setClientRepository(UserRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public void setShowRepository(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	public void setCountersRepository(CountersRepository countersRepository) {
		this.countersRepository = countersRepository;
	}
	
	
	
}
