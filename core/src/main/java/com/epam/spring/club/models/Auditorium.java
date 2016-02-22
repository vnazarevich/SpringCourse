package com.epam.spring.club.models;

public class Auditorium {
	private String name;
	private int placesCount;
	private int vipPlacesCount;
	private int freePlacesCount;
	private int freeVipPlacesCount;

	public Auditorium(String name, int placesCount, int vipPlacesCount) {
		super();
		this.name = name;
		this.placesCount = placesCount;
		this.vipPlacesCount = vipPlacesCount;
		freePlacesCount = placesCount;
		freeVipPlacesCount = vipPlacesCount;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlaceCount() {
		return placesCount;
	}

	public void setPlaceCount(int placeCount) {
		this.placesCount = placeCount;
	}

	public int getFreePlaceCount() {
		return freePlacesCount;
	}

	public void setFreePlaceCount(int freePlaceCount) {
		this.freePlacesCount = freePlaceCount;
	}
	
	

	public int getPlacesCount() {
		return placesCount;
	}

	public void setPlacesCount(int placesCount) {
		this.placesCount = placesCount;
	}

	public int getVipPlacesCount() {
		return vipPlacesCount;
	}

	public void setVipPlacesCount(int vipPlacesCount) {
		this.vipPlacesCount = vipPlacesCount;
	}

	public int getFreePlacesCount() {
		return freePlacesCount;
	}

	public void setFreePlacesCount(int freePlacesCount) {
		this.freePlacesCount = freePlacesCount;
	}

	public int getFreeVipPlacesCount() {
		return freeVipPlacesCount;
	}

	public void setFreeVipPlacesCount(int freeVipPlacesCount) {
		this.freeVipPlacesCount = freeVipPlacesCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditorium other = (Auditorium) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auditorium [name=" + name + ", placesCount=" + placesCount + ", freePlacesCount=" + freePlacesCount
				+ "]";
	}

}
