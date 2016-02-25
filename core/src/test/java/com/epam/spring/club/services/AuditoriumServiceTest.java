package com.epam.spring.club.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.epam.spring.club.models.Auditorium;

public class AuditoriumServiceTest {
private static Map <String, Auditorium> auditoriums;
private static AuditoriumService auditoriumService;
	
/*	static
	{
		auditoriums = new HashMap<String, Auditorium>(){{
			put ("Green", new Auditorium("Green", 100, 10));
			put ("Black", new Auditorium("Black", 200, 20));
			
		}};
		auditoriumService = new AuditoriumService();
	}*/
	@Test
	public void getAuditoriumsTest(){
		assertEquals(2, auditoriumService.getAuditoriums().size() );		
	}
	
	@Test
	public void getAuditoriumByNameTest(){
		assertEquals("Green", auditoriumService.getAuditoriumByName("Green").getName() );
	}
	
	/*@Test
	public void getSeatsNumberTest(){
		assertEquals(100, auditoriumService.getAuditoriumByName("Green").getPlaceCount() );	
	}
	
	@Test
	public void getVipSeatsNumberTest(){
		assertEquals(10, auditoriumService.getAuditoriumByName("Green").getVipPlacesCount() );	
	}
*/
	public static Map<String, Auditorium> getAuditoriums() {
		return auditoriums;
	}


	public static void setAuditoriums(Map<String, Auditorium> auditoriums) {
		AuditoriumServiceTest.auditoriums = auditoriums;
	}


	public static AuditoriumService getAuditoriumService() {
		return auditoriumService;
	}


	public static void setAuditoriumService(AuditoriumService auditoriumService) {
		AuditoriumServiceTest.auditoriumService = auditoriumService;
	}
}
