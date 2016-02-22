package com.epam.spring.club.strategies;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

public class TenthTicketStrategi implements StrategieDiscount {
	private double discount = 0.5;

	public double execute(User currentUser, Event event, LocalDate date) {
		if (9 == currentUser.getNumberOfPurchasedTickets()) {
			return discount;
		} else {
			return 0;
		}

	}
}
