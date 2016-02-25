package com.epam.spring.club.models;

import java.util.List;

public class Auditorium {
	private String auditoriumId;
	private String name;
	private Integer seatsNumber;
	private List<String> vipSeats;

	public Auditorium(String name, int seatsNumber, List<String> vipSeats) {
		this.name = name;
		this.seatsNumber = seatsNumber;
		this.vipSeats = vipSeats;
	}

	public String getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(String auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public List<String> getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(List<String> vipSeats) {
		this.vipSeats = vipSeats;
	}

	@Override
	public String toString() {
		return "Auditorium{" + "name='" + name + '\'' + ", seatsNumber="
				+ seatsNumber + ", vipSeats=" + vipSeats + '}';
	}

}
