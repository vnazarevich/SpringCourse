package com.epam.spring.club.services;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public class UserServiceTest {
	private static UserService userService;
	private static HashMap <String, User> users = new HashMap<String, User>(){{
		put ("Sheldon", new User ("Sheldon", "root", "sheldon@gmail.com", new LocalDate(1980, 3, 3 )));	
		put ("Vik", new User ("Vik", "root", "vik@gmail.com", new LocalDate(1988, 9, 9)));
	}};
	@BeforeClass
	public static void initialisation(){
		userService = new UserService();
		userService.setUsers(users);
	}
	@Test
	public void loginTest(){
		assertFalse(userService.login("Tom", "root"));
		assertTrue(userService.login("Vik", "root")); 
	}
	
	@Test
	public void registrationTest(){
		assertTrue(userService.registration("Leonardo", "1234", "leonardo@gmail.com", new LocalDate(1980, 3, 5)));
	}
	
	@Test
	public void getUserByIdTest(){
		assertNull(userService.getUserById(202));
	}
	
	@Test
	public void getUserByNameTest(){
		assertEquals("Leonardo", userService.getUserByName("Leonardo").getName());
	}

	@Test
	public void getUserByMailTest(){
		assertEquals("Vik", userService.getUserByMail("vik@gmail.com").getName());
	}
	
	@Test
	public void getBookedTicketsTest(){
		assertEquals(0, (userService.getBookedTickets("Vik")).size());
	}
}
