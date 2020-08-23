package com.air.org.asia.model;

import java.io.Serializable;

public enum RoomType implements Serializable{
	
	STANDARD, BUSINESS, PREMIUM;
	
	public String getRoomType() {
        return this.name();
    }

}
