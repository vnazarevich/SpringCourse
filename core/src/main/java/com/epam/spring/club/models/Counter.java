package com.epam.spring.club.models;

import java.util.HashMap;
import java.util.Map;

public class Counter {
	private  int numberCallsBithdaystrategy;
	private  int numberCallsTenthTicketStrategy;

	private Map <User, Integer> usersDiscountsNumbers;
	
	public int getNumberCallsBithdaystrategy() {
		return numberCallsBithdaystrategy;
	}
	public void setNumberCallsBithdaystrategy(int numberCallsBithdaystrategy) {
		this.numberCallsBithdaystrategy = numberCallsBithdaystrategy;
	}
	public int getNumberCallsTenthTicketStrategy() {
		return numberCallsTenthTicketStrategy;
	}
	public void setNumberCallsTenthTicketStrategy(int numberCallsTenthTicketStrategy) {
		this.numberCallsTenthTicketStrategy = numberCallsTenthTicketStrategy;
	}
	public Map<User, Integer> getUsersDiscountsNumbers() {
		return usersDiscountsNumbers;
	}
	public void setUsersDiscountsNumbers(Map<User, Integer> usersDiscountsNumbers) {
		this.usersDiscountsNumbers = usersDiscountsNumbers;
	}
}
