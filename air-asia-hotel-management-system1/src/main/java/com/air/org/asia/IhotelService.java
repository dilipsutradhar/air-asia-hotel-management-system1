package com.air.org.asia;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.air.org.asia.model.HotelStatus;
import com.air.org.asia.model.Hotels;

import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface IhotelService {
	
	@RequestMapping(value = "/app2/getAllRegisteredHotels", method = RequestMethod.GET)
    List<Hotels> findAll();
	
    @RequestMapping(value = "/app2/getHotelInfoByName", method = RequestMethod.GET)
    Hotels getHotelInfo(@RequestParam("hotelName") String hotelname);
    
    @RequestMapping(value = "/app2/getUsingStatus", method = RequestMethod.GET)
    List<Hotels> getHotelsByStatus(@RequestParam("status") HotelStatus status);
    
    @RequestMapping(value = "/app2/getAvailableHotelsByRoomType", method = RequestMethod.GET)
    List<Hotels> getAvailableHotelsByType(@RequestParam("roomType") String roomType);
    
    @RequestMapping(value = "/app2/RegisteraNewHotel", method = RequestMethod.POST)
    Hotels create(@RequestBody Hotels hotel);

	@RequestMapping(value = "/app2/deRegisterHotel", method = RequestMethod.DELETE)
    String delete(@RequestParam("hotelName") String hotelname);
    
   
    
}
