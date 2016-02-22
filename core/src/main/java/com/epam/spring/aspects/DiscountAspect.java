package com.epam.spring.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.joda.time.LocalDate;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.strategies.BirthdayStrategie;

@Aspect
public class DiscountAspect {
	private static Logger log = Logger.getLogger(DiscountAspect.class.getName());
	// in future I will get it from DAO level
	private static int numberCallsBithdaystrategy;
	private static int numberCallsTenthTicketStrategy;
	
	public DiscountAspect() {
		System.out.println("DiscountAspect()");
		numberCallsBithdaystrategy=10;
		numberCallsTenthTicketStrategy=0;
	}
	
	//execute(User currentUser, Event event, LocalDate date)
	@Before("execution(* *.BirthdayStrategie.execute(..)) && args(currentUser, event, date)")
	private void countCallsBithdaystrategy(User currentUser, Event event, LocalDate date){
		numberCallsBithdaystrategy +=1;
		log.info("DiscountAspect countered " + numberCallsBithdaystrategy + " times calling BirthdayStrategy" );
	}

	public static int getNumberCallsBithdaystrategy() {
		return numberCallsBithdaystrategy;
	}

	public static void setNumberCallsBithdaystrategy(int numberCallsBithdaystrategy) {
		DiscountAspect.numberCallsBithdaystrategy = numberCallsBithdaystrategy;
	}

	public static int getNumberCallsTenthTicketStrategy() {
		return numberCallsTenthTicketStrategy;
	}

	public static void setNumberCallsTenthTicketStrategy(int numberCallsTenthTicketStrategy) {
		DiscountAspect.numberCallsTenthTicketStrategy = numberCallsTenthTicketStrategy;
	}

	
	

}
