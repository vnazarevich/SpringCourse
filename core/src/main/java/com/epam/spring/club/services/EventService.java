package com.epam.spring.club.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import com.epam.spring.club.EventRate;
import com.epam.spring.club.DAO.interfaces.EventRepository;
import com.epam.spring.club.DAO.interfaces.ShowRepository;
import com.epam.spring.club.DAO.interfaces.TicketRepository;
import com.epam.spring.club.models.Auditorium;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;

public class EventService {
	private static Logger log = Logger.getLogger(EventService.class.getName());
	private HashMap<String, Event> events;
	private EventRepository eventRepository;
	private ShowRepository showRepository;
	private TicketRepository ticketRepository;

	public Event createEvent(String eventName, int bacePrice, EventRate rate) {
		return eventRepository.createEvent(eventName, bacePrice, rate);
	}

	public Event removeEvent(String name) {
		Event event = events.get(name);
		events.remove(name);
		log.info("remove event " + name);
		return event;
	}

	public ArrayList<Event> getAllEvents() {
		log.info("start getAllEvents(), count = " + events.size() + " events");
		return new ArrayList(events.values());
	}

	public Event getEventByName(String name) {
		Event event = events.get(name);
		// log.info("get event " + event.toString() +" by name" );
		return event;
	}

	public HashMap<String, Event> getEvents() {
		return events;
	}

	public Show assignAuditorium(Event event, Auditorium auditorium, Date date) {
		Show show = showRepository.createShow(event, auditorium, date);
		if (show != null) {
			createTicketsForTheShow(show, event, auditorium);
		}
		return show;
	}

	public void setEvents(HashMap<String, Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		events.put(event.getName(), event);
		log.info("add new event " + event.toString());

	}

	public List<Ticket> createTicketsForTheShow(Show show, Event event,
			Auditorium auditorium) {
		List<Ticket> tikets = new ArrayList<Ticket>();
		int seat = 1;
		int price = getPriceRate(event.getBacePrice(), event.getRate());
		List<String> vipSeats = auditorium.getVipSeats();
		while (seat <= auditorium.getSeatsNumber()) {
			if (vipSeats.contains(Integer.toString(seat))) {
				tikets.add(ticketRepository.createTicket(show.getShowId(),
						seat, true, true, (price * 2)));
			} else {
				tikets.add(ticketRepository.createTicket(show.getShowId(),
						seat, false, true, price));
			}
			seat++;
		}
		return tikets;
	}

	private int getPriceRate(int price, EventRate rate) {
		switch (rate) {
		case HIGH:
			return (int) (price * 1.2);
		case LOW:
			return (int) (price * 0.8);
		default:
			return price;
		}

	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public void setShowRepository(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	public void setTicketRepository(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	
	
}
