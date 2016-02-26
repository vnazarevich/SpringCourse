package com.epam.spring.club.strategies;

import java.util.logging.Logger;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;
import com.epam.spring.club.service.DiscountService;

public class BirthdayStrategie implements StrategieDiscount {
	private static Logger log = Logger.getLogger(BirthdayStrategie.class.getName());
	private double discount = 0.05;

	public double execute(User currentUser, Event event, LocalDate date) {
		if (currentUser.getBirthDay().getMonthOfYear() == (date.getMonthOfYear()) &&
				currentUser.getBirthDay().getDayOfMonth() == (date.getDayOfMonth())) {
			//log.info("BirthdayStrategie return discount = " + discount);
			return discount;
		} else {
			//log.info("BirthdayStrategie return discount = " + discount);
			return 0;
		}
	}
}
 