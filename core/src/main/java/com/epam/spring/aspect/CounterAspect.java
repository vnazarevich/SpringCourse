package com.epam.spring.aspect;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.epam.spring.club.DAO.interfaces.CountersRepository;
import com.epam.spring.club.DAO.interfaces.ShowRepository;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;

@Aspect
public class CounterAspect {
	private ShowRepository showRepository;
    private CountersRepository countersRepository;

    public void setCountersRepository(CountersRepository countersRepository) {
        this.countersRepository = countersRepository;
    }

    public void setShowRepository(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Pointcut("execution(* com.epam.spring.club.service.EventService.getByName(..))")
    public void eventGetByName(){}

    @Pointcut("execution(* com.epam.spring.club.service.BookingService.getTicketPrice(..)) && args(event, auditoriumName, date, seat, userName)")
    public void eventGetTicketPrice(Event event, String auditoriumName, Date date, int seat, String userName){}

    @Pointcut("execution(* com.epam.spring.club.service.BookingService.bookTicket(..)) && args(userName, ticket)")
    public void eventBookedTicket(String userName, Ticket ticket){}

    @AfterReturning(value = "eventGetByName()", returning = "result")
    public void countGetByNameCalls(Object result){
        if((Event)result != null){
            countersRepository.addCountEventRetrievedByName(((Event) result).getEventId());
        }
    }

    @After("eventGetTicketPrice(event, auditoriumName, date, seat, userName)")
    public void countGetTicketPrice(Event event, String auditoriumName, Date date, int seat, String userName){
        countersRepository.addCountEventRetrievedByTicketPrice(event.getEventId());
    }

    @After("eventBookedTicket(userName, ticket)")
    public void countBookedTickets(String userName, Ticket ticket){
        Show show = showRepository.getShow(ticket.getShowId());
        if(show != null) {
            countersRepository.addCountEventRetrivedByBookedTicket(show.getEvent());
        }
        else {
           System.out.println("No show for this ticket found");
        }
    }
}
