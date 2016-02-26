package com.epam.spring.aspect;

import java.util.Random;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.epam.spring.club.DAO.interfaces.ClientTicketRepository;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.Ticket;
import com.epam.spring.club.models.User;
import com.epam.spring.club.service.BookingService;

@Aspect
public class LuckyWinnerAspect {
	private static Logger log = Logger.getLogger(BookingService.class.getName());
	 private ClientTicketRepository clientTicketRepository;
	 
	@Before("execution(* *.bookTicket(..)) && args(userName, ticket)")
	private void isUserLuky(String userName, Ticket ticket){
		  if (new Random().nextBoolean()){
			  ticket.setPrice(0);
			  log.info("User " + userName + " is lucky ");
		  }	
	}

	public void setClientTicketRepository(
			ClientTicketRepository clientTicketRepository) {
		this.clientTicketRepository = clientTicketRepository;
	}
	
	

}
