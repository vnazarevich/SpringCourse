package com.epam.spring.club.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.epam.spring.club.models.Auditorium;

public class AuditoriumService {
	private static Logger log = Logger.getLogger(AuditoriumService.class.getName());
	private static Map <String, Auditorium> auditoriums;
	
	static
	{
		auditoriums = new HashMap<String, Auditorium>(){{
			put ("Green", new Auditorium("Green", 100, 10));
			put ("Black", new Auditorium("Black", 200, 20));
			
		}};
	}
	
	public ArrayList<Auditorium> getAuditoriums(){
		return new ArrayList<Auditorium>(auditoriums.values());
	}
	
	public Auditorium getAuditoriumByName(String name){
		return auditoriums.get(name);
	}
	
	public int getSeatsNumber(String name){
		return auditoriums.get(name).getPlaceCount();
	}
	
	public int getVipSeatsNumber(String name){
		return auditoriums.get(name).getVipPlacesCount();
	}

	public static void setAuditoriums(Map<String, Auditorium> auditoriums) {
		AuditoriumService.auditoriums = auditoriums;
	}
	
	
}
