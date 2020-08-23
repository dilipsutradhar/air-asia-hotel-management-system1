package com.air.org.asia.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.air.org.asia.model.Booking;

@Repository
public interface IBookingService extends CrudRepository<Booking, String>  {
	
    //List<Booking> findAll();
	
    Booking getBookingInfoByCustName(String customerName);
    
    //BookingStatus getBookingStatus(int id);
    
    //Booking save(Booking hotel);

    //String delete(String customerName);

}
