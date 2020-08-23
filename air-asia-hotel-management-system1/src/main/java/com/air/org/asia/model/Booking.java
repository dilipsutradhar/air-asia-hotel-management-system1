package com.air.org.asia.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	
	@Id
	int id;
	String Hotelname;
	RoomDetails roomDetails;
	int guestCount;
	@Size(max=10,min=5,message="CustomerName Length hsould be 5-10 char")
	String custName;
	String emailId;
	Long phoneNo;
	String address;
	//@Temporal(TemporalType.DATE)
	//@CreationTimestamp
	Date checkInDate;
	Date checkOutDate;
	BookingStatus status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelname() {
		return Hotelname;
	}
	public void setHotelname(String hotelname) {
		Hotelname = hotelname;
	}
	public RoomDetails getRoomDetails() {
		return roomDetails;
	}
	public void setRoomDetails(RoomDetails roomDetails) {
		this.roomDetails = roomDetails;
	}
	public int getGuestCount() {
		return guestCount;
	}
	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}

}
