package com.epam.spring.aspects;

import java.util.Map;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.joda.time.LocalDate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.club.DAO.CounterDaoImp;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

@Aspect
public class DiscountAspect {
	private static Logger log = Logger.getLogger(DiscountAspect.class.getName());
	private CounterDaoImp counterDaoImp;

	@Before("execution(* com.epam.spring.club.strategies.BirthdayStrategie.execute(..)) && args(currentUser, event, date)")
	private void countCallsBithdaystrategy(User currentUser, Event event, LocalDate date) {
		int number = counterDaoImp.getNumberCallsBithdaystrategy();
		number++;
		counterDaoImp.setNumberCallsBithdaystrategy(number);
		log.info("DiscountAspect countered __" + number + " times calling BirthdayStrategy");
	}

	@Before("execution(* com.epam.spring.club.strategies.TenthTicketStrategi.execute(..)) && args(currentUser, event, date)")
	private void countCallsTenthTicketStrategy(User currentUser, Event event, LocalDate date) {
		int number = counterDaoImp.getNumberCallsTenthTicketStrategy();
		number++;
		counterDaoImp.setNumberCallsTenthTicketStrategy(number);
		log.info("DiscountAspect countered __" + number + " times calling BirthdayStrategy");
		System.out.println("DiscountAspect countered __" + number + " times calling BirthdayStrategy");
	}
	
	@Before("execution(* com.epam.spring.club.services.DiscountService.getDiscount(..)) && args(currentUser, event, date)")
	private void countDiscountsReciveUser(User currentUser, Event event, LocalDate date) {
		Map <User, Integer> usersDiscountsNumbers = counterDaoImp.getUsersDiscountsNumbers();		
		int number = usersDiscountsNumbers.get(currentUser);
		usersDiscountsNumbers.put(currentUser, number++);
		counterDaoImp.setUsersDiscountsNumbers(usersDiscountsNumbers);
		log.info("DiscountAspect countered __" + number + " times calling BirthdayStrategy");
		System.out.println("DiscountAspect countered __" + number + " times calling BirthdayStrategy");
	}

	public void setCounterDaoImp(CounterDaoImp counterDaoImp) {
		this.counterDaoImp = counterDaoImp;
	}



	
}
