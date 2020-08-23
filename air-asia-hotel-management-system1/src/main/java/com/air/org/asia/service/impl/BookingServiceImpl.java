package com.air.org.asia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.air.org.asia.model.Booking;
import com.air.org.asia.service.IBookingService;

@Service
public class BookingServiceImpl {

	@Autowired
	IBookingService bookingService;

	public List<Booking> getAll() {
		return (List<Booking>) bookingService.findAll();
	}

	public Booking getBookingInfoByCustomerName(@RequestParam String customerName) {
		return bookingService.getBookingInfoByCustName(customerName);

	}

	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.save(booking);

	}

	public String removeExistingBooking(String customerName) {
		// TODO Auto-generated method stub

		Booking booking = bookingService.getBookingInfoByCustName(customerName);
		bookingService.delete(booking);

		return "Deleted " + customerName;
	}

}
