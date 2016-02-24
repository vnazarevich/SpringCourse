package com.epam.spring.club.DAO;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDate;

import com.epam.spring.club.models.Counter;
import com.epam.spring.club.models.User;

//MockClass for testing
public class DataBase {
	private Counter counter;

	{
		counter = new Counter();
		int numberCallsBithdaystrategy = 0;
		int numberCallsTenthTicketStrategy = 3;	
		Map <User, Integer> usersDiscountsNumbers = new HashMap<User, Integer>(){{
			put (new User ("Sheldon", "root", new LocalDate(1980, 3, 3)), 0);	
			put (new User ("Leonardo", "root", new LocalDate(1986, 4, 4)), 2);	
			put (new User ("Volovec", "root", new LocalDate(1983, 5, 5)), 5);	
		}};
		counter.setNumberCallsBithdaystrategy(numberCallsBithdaystrategy);
		counter.setNumberCallsTenthTicketStrategy(numberCallsTenthTicketStrategy);
		counter.setUsersDiscountsNumbers(usersDiscountsNumbers);
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	
	

}
