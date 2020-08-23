package com.air.org.asia.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.air.org.asia.model.Booking;
import com.air.org.asia.model.BookingStatus;
import com.air.org.asia.model.CustomerDetails;
import com.air.org.asia.model.RoomDetails;
import com.air.org.asia.model.RoomType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMessageGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Booking b = new Booking();
		b.setId(1);
		b.setHotelname("Natraj");
		
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setRoomNo(101);
		roomDetails.setRoomName("");
		roomDetails.setRoomType(RoomType.STANDARD);
		b.setRoomDetails(roomDetails);
		
		b.setGuestCount(5);
		
		CustomerDetails cd = new CustomerDetails();
		b.setCustName("Dilip Sutradhar");
		b.setEmailId("dilip.sutradhar7@gmail.com");
		b.setPhoneNo(8007947748L);
		b.setAddress("202-Pan Bazar, West Garo Hills ,Tura, Meghalaya,794001");
		//b.setCustomerDetails(cd);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = format.parse("26/10/1985");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		b.setCheckInDate(date);
		b.setCheckOutDate(date);
		b.setStatus(BookingStatus.CONFIRMED);
		
		
		ObjectMapper om = new ObjectMapper();
	      String jsonString = null;
		try {
			jsonString = om.writeValueAsString(b);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(jsonString);

	}

}
