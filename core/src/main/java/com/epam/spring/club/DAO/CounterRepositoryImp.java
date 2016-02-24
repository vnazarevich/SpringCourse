package com.epam.spring.club.DAO;


import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDate;

import com.epam.spring.aspects.DiscountAspect;
import com.epam.spring.club.models.Counter;
import com.epam.spring.club.models.User;

public class CounterRepositoryImp extends DAO implements CounterRepository {
	
	//MockData for testing
	DataBase db = new DataBase();
	private Counter counter;
	
	public int getNumberCallsBithdaystrategy() {
		Counter counter = db.getCounter();
		return counter.getNumberCallsBithdaystrategy();
	}
	public void setNumberCallsBithdaystrategy(int numberCallsBithdaystrategy) {
		Counter counter = db.getCounter();
		counter.setNumberCallsBithdaystrategy(numberCallsBithdaystrategy);
	}
	public int getNumberCallsTenthTicketStrategy() {
		Counter counter = db.getCounter();
		return counter.getNumberCallsTenthTicketStrategy();
	}
	public void setNumberCallsTenthTicketStrategy(int numberCallsTenthTicketStrategy) {
		Counter counter = db.getCounter();
		counter.setNumberCallsTenthTicketStrategy(numberCallsTenthTicketStrategy);
	}
	public Map<User, Integer> getUsersDiscountsNumbers() {
		Counter counter = db.getCounter();
		return counter.getUsersDiscountsNumbers();
	}
	public void setUsersDiscountsNumbers(Map<User, Integer> usersDiscountsNumbers) {
		Counter counter = db.getCounter();
		counter.setUsersDiscountsNumbers(usersDiscountsNumbers);
	}
	


}
