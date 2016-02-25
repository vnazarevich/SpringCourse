package com.epam.spring.club.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.joda.time.LocalDate;

import com.epam.spring.club.services.DiscountService;

public class User {
	private static Logger log = Logger.getLogger(User.class.getName());
	private int id;
	private String name;
	private String pass;
	private String mail;
	private LocalDate birthDay;
	private Map<Event, Integer> bookedTickets;
	private int numberOfPurchasedTickets;
	//private Map<Event, Integer> bookTickets;

	public User(String name, String pass, String mail, LocalDate birthDay) {
		super();
		this.name = name;
		this.pass = pass;
		this.mail = mail;
		this.birthDay = birthDay;
		//id = new Random().nextInt(1000);
		bookedTickets = new HashMap<Event, Integer>();
		numberOfPurchasedTickets = 0;
		log.info(this.toString());
	}
	
	public User(String name, String pass, LocalDate birthDay) {
		super();
		this.name = name;
		this.pass = pass;
		this.birthDay = birthDay;
		//id = new Random().nextInt(1000);
		bookedTickets = new HashMap<Event, Integer>();
		numberOfPurchasedTickets = 0;
	}

	public User(int id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}
	
	public User(String name, String mail) {
		super();
		this.name = name;
		this.mail = mail;
	}



	public int getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Map<Event, Integer> getBookedTickets() {
		return bookedTickets;
	}

	public void setBookedTickets(Map<Event, Integer> bookedTickets) {
		this.bookedTickets = bookedTickets;
	}

	public int getNumberOfPurchasedTickets() {
		return numberOfPurchasedTickets;
	}

	public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
		this.numberOfPurchasedTickets = numberOfPurchasedTickets;
	}

	/*public Map<Event, Integer> getBookTickets() {
		return bookTickets;
	}

	public void setBookTickets(Map<Event, Integer> bookTickets) {
		this.bookTickets = bookTickets;
	}*/

	@Override

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setBookTickets(Event event, int count) {
		if (bookedTickets.containsKey(event)) {
			bookedTickets.put(event, bookedTickets.get(event) + count);
			numberOfPurchasedTickets += count;
		} else {
			bookedTickets.put(event, count);
			numberOfPurchasedTickets += count;
		}

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", mail=" + mail + ", birthDay=" + birthDay
				+ ", bookedTickets=" + bookedTickets + ", numberOfPurchasedTickets=" + numberOfPurchasedTickets+ "]";
	}
	

}
