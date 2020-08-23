package com.air.org.asia.model;

import java.io.Serializable;

public enum BookingStatus implements Serializable{
	
	CONFIRMED, PENDING, CANCELLED;
	
	public String getBookingStatus() {
        return this.name();
    }
}
