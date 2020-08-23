package com.air.org.asia.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.air.org.asia.exception.BookingNotFoundException;
import com.air.org.asia.model.Booking;
import com.air.org.asia.service.impl.BookingServiceImpl;

@Controller
@RestController
public class HotelBookingController {

	@Autowired
	BookingServiceImpl bookingService;

	@RequestMapping(method = RequestMethod.GET, path = "/app1/booking/getAllAvailableBookings")
	@ResponseBody
	public ResponseEntity<List<Booking>> findAll() {
		List<Booking> b = bookingService.getAll();
		if (b == null) {
			return new ResponseEntity<List<Booking>>(b, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(b, HttpStatus.FOUND);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/app1/booking/getBookingInfoByCustomerName")
	public ResponseEntity<Booking> getBookingInfoByCustomerName(@Valid @NotEmpty @RequestParam String customerName) {
		Booking b = bookingService.getBookingInfoByCustomerName(customerName);
		if (b == null) {
			throw new BookingNotFoundException("Not found"+customerName);
		}
		return new ResponseEntity(b, HttpStatus.FOUND);

	}

	@RequestMapping(method = RequestMethod.POST, path = "/app1/booking/createBooking")
	public ResponseEntity<Booking> createBooking(@Valid @NotEmpty @RequestBody Booking booking) {
		Booking b = bookingService.createBooking(booking);
		if (b == null) {
			return new ResponseEntity<Booking>(b, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(b, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/app1/deleteBookingByCustomerNameOrBookingId")
	public ResponseEntity<String> createBooking(@Valid @NotEmpty @RequestParam String customerName) {
		String msg = bookingService.removeExistingBooking(customerName);

		return new ResponseEntity(msg, HttpStatus.OK);
	}

}
