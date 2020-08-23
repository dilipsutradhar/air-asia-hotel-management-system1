package com.air.org.asia.exception;

public class BookingNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BookingNotFoundException(String msg) {
		super(msg);
	}

}
