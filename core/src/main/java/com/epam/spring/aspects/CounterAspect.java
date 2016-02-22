package com.epam.spring.aspects;

import java.util.HashMap;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.services.AuditoriumService;

@Aspect
public class CounterAspect {
	public class Counter{
		private int numberCallingsByName;
		private int numberOfPriceRequestings;
		private int numberOfBookedTickets;
		public int getNumberCallingsByName() {
			return numberCallingsByName;
		}
		public void setNumberCallingsByName(int numberCallingsByName) {
			this.numberCallingsByName = numberCallingsByName;
		}
		public int getNumberOfPriceRequestings() {
			return numberOfPriceRequestings;
		}
		public void setNumberOfPriceRequestings(int numberOfPriceRequestings) {
			this.numberOfPriceRequestings = numberOfPriceRequestings;
		}
		public int getNumberOfBookedTickets() {
			return numberOfBookedTickets;
		}
		public void setNumberOfBookedTickets(int numberOfBookedTickets) {
			this.numberOfBookedTickets = numberOfBookedTickets;
		}
		
		
		
	}

	private static Logger log = Logger.getLogger(AuditoriumService.class.getName());
	private static HashMap<String, Counter> countersMap = new HashMap<String, Counter>();

	@Before("execution(* *.getEventByName(..)) && args(eventName,..)")
	private void logCallEventByName(JoinPoint joinPoint, String eventName) {
		int count;
		Counter counter;
		if (countersMap.containsKey(eventName)) {
			counter = countersMap.get(eventName);
			count = counter.getNumberCallingsByName() + 1;
		} else {
			counter = new Counter();
			count = 1;
		}
		counter.setNumberCallingsByName(count);
		countersMap.put(eventName, counter);
		log.info("Event " + eventName + " was called " + counter.getNumberCallingsByName() + " times" );		
	}
	
	@Before("execution(* *.getTicketPrice(..)) && args(event, date, user)")
	private void logEventPriceRequest(Event event, LocalDate date, User user){
		String eventName = event.getName();
		int count;
		Counter counter;
		if (countersMap.containsKey(eventName)) {
			counter = countersMap.get(eventName);
			count = counter.getNumberOfPriceRequestings() + 1;
		} else {
			counter = new Counter();
			count = 1;
		}
		counter.setNumberOfPriceRequestings(count);
		countersMap.put(eventName, counter);
		log.info("Prise on " + eventName + " was called " + counter.getNumberOfPriceRequestings() + " times" );
	}
	
	@Before("execution(* *.bookTicket(..)) && args(user, event, count)")
	//bookTicket(User user, Event event, int count)
	private void logNumberOfBookedTickets(User user, Event event, int count){
		String eventName = event.getName();
		int numberOfBookedTickets;
		Counter counter;
		if (countersMap.containsKey(eventName)) {
			counter = countersMap.get(eventName);
			numberOfBookedTickets = counter.getNumberOfBookedTickets() + 1;
		} else {
			counter = new Counter();
			numberOfBookedTickets = 1;
		}
		counter.setNumberOfBookedTickets(numberOfBookedTickets);
		countersMap.put(eventName, counter);
		log.info("Tickets on " + eventName + " was booked " + counter.getNumberOfBookedTickets() + " times" );
		
	}
	
	public static HashMap<String, Counter> getCountersMap() {
		return countersMap;
	}

	public static void setCountersMap(HashMap<String, Counter> numberCallsEventsByName) {
		CounterAspect.countersMap = numberCallsEventsByName;
	}
	
	
}
