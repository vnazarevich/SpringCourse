package com.epam.spring.club.services;

import java.util.List;
import java.util.logging.Logger;

import com.epam.spring.club.DAO.interfaces.AuditoriumRepository;
import com.epam.spring.club.models.Auditorium;

public class AuditoriumService {
	private static Logger log = Logger.getLogger(AuditoriumService.class.getName());
	private AuditoriumRepository auditoriumRepository;

	public List<Auditorium> getAuditoriums(){
		return auditoriumRepository.getAuditoriumList();
	}
	
	 public Auditorium addAuditorium(String name, int seats, List<String> vipSeats){
	        return auditoriumRepository.addAuditorium(name, seats, vipSeats);
	    }
	
	/*
	 * return null if an auditorim with such name doesn`t exist
	 */		
	public Auditorium getAuditoriumByName(String name){
		for (Auditorium auditorium: getAuditoriums()){
			if (auditorium.getName().equals(name)){
				return auditorium;
			}
		}
		return null;
	}
	
	/*
	 * return 0 if an auditorim with such name doesn`t exist
	 */	
	public int getSeatsNumber(String name){
		for (Auditorium auditorium: getAuditoriums()){
			if (auditorium.getName().equals(name)){
				return auditorium.getSeatsNumber();
			}
		}
		return 0;
	}
	
	
	
	
}
