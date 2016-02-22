package com.epam.spring.club.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.strategies.StrategieDiscount;

public class DiscountService {
	private static Logger log = Logger.getLogger(DiscountService.class.getName());
	
	private List <StrategieDiscount> discountStrategiesList = new ArrayList <StrategieDiscount> ();
	
	public DiscountService() {
		//discountStrategiesList = new ArrayList <StrategieDiscount> ();
	}
	
	public double getDiscount(User user, Event event, LocalDate date){
		List <Double> discountsList = new ArrayList();
		for (StrategieDiscount strategy: discountStrategiesList ){
			 discountsList.add(strategy.execute(user, event, date));
		}
		Collections.sort(discountsList);
		Collections.reverse(discountsList);
		log.info("discount = " + discountsList.get(0));
		return discountsList.get(0);
	}

	public List<StrategieDiscount> getDiscountStrategiesList() {
		return discountStrategiesList;
	}

	public void setDiscountStrategiesList(List<StrategieDiscount> discountStrategiesList) {
		this.discountStrategiesList = discountStrategiesList;
	}
	
	
}
