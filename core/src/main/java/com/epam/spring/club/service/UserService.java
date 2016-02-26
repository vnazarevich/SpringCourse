package com.epam.spring.club.service;

import java.util.HashMap;
import java.util.logging.Logger;

import com.epam.spring.club.DAO.interfaces.ClientTicketRepository;
import com.epam.spring.club.DAO.interfaces.UserRepository;
import com.epam.spring.club.models.User;

public class UserService {
    private String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private UserRepository clientRepository;
    private ClientTicketRepository clientTicketRepository;
	private static Logger log = Logger.getLogger(UserService.class.getName());
	private static HashMap <String, User> users;
	
	
	public String registerUser(String name, String email){
		if(email.matches(EMAIL_REGEX) && name.length() > 0){
            return clientRepository.registerUser(name, email);
        }
        else {
        	log.info("New user "+ name +"  was registred" );
            return null;
        }
    }

	 public User removeUser(User client){
	        User removedUser = clientRepository.removeUser(client);
	        if(removedUser != null){
	            return removedUser;
	        }
	        else {
	        	log.info("No such client to remove");
	            return null;
	        }
	    }

	    public  User getById(String id){
	        User client = clientRepository.getUserById(id);
	        if(client != null) {
	        	
	            return client;
	        }
	        else {
	        	log.info("No customer with such id found");
	            return null;
	        }
	    }

	    public User getUserByEmail(String email){
	        User client = clientRepository.getUserByEmail(email);
	        if(client != null){
	            return client;
	        }
	        else {
	        	log.info("No customer with such email found");
	            return null;
	        }
	    }

	    public User getUsersByName(String name){
	        User client = clientRepository.getUserByName(name);
	        if(client != null){
	            return client;
	        }
	        else {
	        	log.info("No customer with such name found");
	            return null;
	        }
	    }
	public void setClientRepository(UserRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public void setClientTicketRepository(
			ClientTicketRepository clientTicketRepository) {
		this.clientTicketRepository = clientTicketRepository;
	}

	
	

}
