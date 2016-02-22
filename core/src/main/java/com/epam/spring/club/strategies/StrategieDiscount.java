package com.epam.spring.club.strategies;

import org.joda.time.LocalDate;

import com.epam.spring.club.models.Event;
import com.epam.spring.club.models.User;

public interface StrategieDiscount {
	public double execute(User currentUser, Event event, LocalDate date);

}
