package com.epam.spring.club.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.epam.spring.club.models.User;
import com.epam.spring.club.strategies.BirthdayStrategie;
import com.epam.spring.club.strategies.StrategieDiscount;
import com.epam.spring.club.strategies.TenthTicketStrategi;

public class DiscountServiceTest {

	@Autowired
	private static DiscountService discountService;
	@Autowired
	private ApplicationContext appContext;

	@BeforeClass
	public static void initialisation() {
		discountService = new DiscountService();
		ArrayList<StrategieDiscount> discountStrategiesList = new ArrayList<StrategieDiscount>() {
			{
				add(new BirthdayStrategie());
				add(new TenthTicketStrategi());
			}
		};
		discountService.setDiscountStrategiesList(discountStrategiesList);
	}

	@Test
	public void getDiscountTest() {

		User user = new User("Caty", "root", "cat@gmail.com", new LocalDate(1990, 2, 2));

		assertEquals(0, discountService.getDiscount(user, null, new LocalDate(1990, 3, 2)), 0.00001);

		user.setNumberOfPurchasedTickets(9);
		assertEquals(0.5, discountService.getDiscount(user, null, new LocalDate(1990, 2, 2)), 0.00001);

	}
}
