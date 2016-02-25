package com.epam.spring.club.services;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.joda.time.LocalDate;

import com.epam.spring.club.ClubManager;
import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

public class UserService {
	private static Logger log = Logger.getLogger(UserService.class.getName());
	private static HashMap <String, User> users;
	
	public boolean login(String login, String pass){
		checkLoginPass(login, pass);
		if (checkLoginPass(login, pass)){
			log.info("Authentication is successful");
			return true;
		} else {
			log.info("Authentication failed");
			return false;
		}
	}
	
	public boolean registerUser (String login, String pass, String mail, LocalDate bithday){	
		try {
			users.put(login, new User(login, pass, mail, bithday));
			log.info("New user "+ login +"  was registred" );
			return true;
		}catch (Exception e){
			log.info("Registration failed");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean registerUser (String login, String mail){	
		try {
			users.put(login, new User(login, mail));
			log.info("New user "+ login +"  was registred" );
			return true;
		}catch (Exception e){
			log.info("Registration failed");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public User getUserById(int id){
		for (User user: users.values()){
			if (user.getId() == id){
				log.info("find user " + user.getName() + " by id=" +id);
				return user;
			}
		}
		log.info("user with" + " id=" +id + "does not exist");
		return null;
	}
	
	public Map <Event, Integer> getBookedTickets(String name){
		log.info("find booked tickets for user " + name );
		return users.get(name).getBookedTickets();
	}
	
	public User getUserByName(String name){
		for (User user: users.values()){
			if (user.getName() == name){
				log.info("find user " + user.getName() + " by name=" + name);
				return user;
			}
		}
		log.info("user with" + " name=" + name + "does not exist");
		return null;
	}
	
	public User getUserByMail(String mail){
		for (User user: users.values()){
			if (user.getMail() == mail){
				log.info("find user " + user.getName() + " by mail=" + mail);
				return user;
			}
		}
		log.info("user with" + " mail=" + mail + "does not exist");
		return null;
	}

	private boolean checkLoginPass(String login, String pass){
		User user = users.get(login);
		if (null != user && user.getPass().equals(pass)){
			//Session imitation
			ClubManager.currentUser = user;
			return true;
		} else {
			return false;
		}
		
	}

	public static HashMap<String, User> getUsers() {
		return users;
	}

	public static void setUsers(HashMap<String, User> users) {
		UserService.users = users;
	}
	
	

}
