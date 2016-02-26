package com.epam.spring.club.service;

import java.util.Date;
import java.util.logging.Logger;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.epam.spring.club.DAO.interfaces.ClientTicketRepository;
import com.epam.spring.club.DAO.interfaces.CountersRepository;
import com.epam.spring.club.DAO.interfaces.ShowRepository;
import com.epam.spring.club.DAO.interfaces.TicketRepository;
import com.epam.spring.club.DAO.interfaces.UserRepository;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;
import com.epam.spring.club.models.User;

@ContextConfiguration("classpath:spring.xml")
public class BookingService {
	private static Logger log = Logger.getLogger(BookingService.class.getName());
	private EventService eventService;
    private TicketRepository ticketRepository;
    private ClientTicketRepository clientTicketRepository;
    private UserRepository clientRepository;
    private CountersRepository countersRepository;
    @Autowired
    private UserService clientService;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private DiscountService discountService;
    
    public Ticket getTicketPrice(Event event, String auditoriumId, Date date, int seat, String userName){
        Show show = showRepository.getShow(event.getEventId(), auditoriumId, date);
        User user= clientRepository.getUserByName(userName);
        
        double discount = discountService.getDiscount(new User("VVV", "f@gmail.com"), event, new LocalDate(date));
        Ticket ticket = ticketRepository.getTicket(show.getShowId(), seat);
        ticket.setPrice((int)((1-discount)*ticket.getPrice()));
        return ticket;
//        return ticketRepository.getTicket(show.getShowId(), seat);
    }
	
	public Ticket bookTicket(String userName, Ticket ticket){
        User user = clientRepository.getUserByName(userName);

        if(user != null){
            clientTicketRepository.addTicket(String.valueOf(user.getId()), ticket.getTicketId());
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
