package com.air.org.asia.model;

public class Hotels {
	
	String id;
	String hotelName;
	Rooms rooms;
	String hotelAddress;
	HotelStatus status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Rooms getRooms() {
		return rooms;
	}
	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public HotelStatus getStatus() {
		return status;
	}
	public void setStatus(HotelStatus status) {
		this.status = status;
	}
}
