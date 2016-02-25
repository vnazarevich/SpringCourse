package com.epam.spring.aspects;

import java.util.Random;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.services.BookingService;

@Aspect
public class LuckyWinnerAspect {
	private static Logger log = Logger.getLogger(BookingService.class.getName());
	
	@Before("execution(* *.bookTicket(..)) && args(user, event, count)")
	private void isUserLuky(User user, Event event, int count){
		  if (new Random().nextBoolean()){
			  event.setTicketPrice(0);
			  log.info("User " + user.getName() + " is lucky ");
			  System.out.println("User " + user.getName() + " is lucky ");
		  }	
	}

}
