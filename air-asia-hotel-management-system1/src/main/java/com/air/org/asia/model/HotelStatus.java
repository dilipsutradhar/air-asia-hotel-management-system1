package com.air.org.asia.model;

import java.io.Serializable;

public enum HotelStatus implements Serializable {
	
	RECEIVING, FULL, MAINTAINANCE;

	public String getStatus() {
        return this.name();
    }
	
}