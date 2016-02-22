package com.epam.spring.club.DAO;

import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

public class DAO {
	private HashMap <String, User> users = new HashMap<String, User>(){{
		put ("Sheldon", new User ("Sheldon", "root", new LocalDate(1980, 3, 3)));	
		put ("Leonardo", new User ("Leonardo", "root", new LocalDate(1986, 4, 4)));	
		put ("Volovec", new User ("Volovec", "root", new LocalDate(1983, 5, 5)));	
		put ("Gutrapalli", new User ("Gutrapalli", "root", new LocalDate(1982, 9, 9)));	
		put ("Vik", new User ("Vik", "root", new LocalDate(1988, 9, 9)));
	}};
	private HashMap <String, Event> events = new HashMap <String, Event>(){{
		put ("Aerosmith", new Event("Aerosmith", "GREEN", new LocalDate(2016,3,7), new LocalTime(19,0,0), 100, 400));
		put ("Scorpions", new Event("Scorpions", "BLACK", new LocalDate(2016,4,7), new LocalTime(20,0,0), 120, 400));
	}};

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}
	
	public void getUser(HashMap<String, User> users) {
		this.users = users;
	}
	
	public void setUser(User user) {
		users.put(user.getName(), user);
	}

	public HashMap<String, Event> getEvents() {
		return events;
	}

	public void setEvents(HashMap<String, Event> events) {
		this.events = events;
	}

}
