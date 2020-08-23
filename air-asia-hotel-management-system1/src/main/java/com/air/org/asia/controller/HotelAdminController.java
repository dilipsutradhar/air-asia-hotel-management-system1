package com.air.org.asia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.air.org.asia.IhotelService;
import com.air.org.asia.model.HotelStatus;
import com.air.org.asia.model.Hotels;

@RestController
public class HotelAdminController {

	@Autowired
	IhotelService hotelService;
	
	@RequestMapping(value = "/app1/admin/service/getAllRegisteredHotelsInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Hotels> findAll() {
		List<Hotels> h = hotelService.findAll();
		return new ResponseEntity(h, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/app1/admin/service/show/hotelInfoByName", method = RequestMethod.GET)
	// @ResponseBody
	public ResponseEntity<Hotels> getHotelInfoByName(@RequestParam("hotelName") String hotelName) {

		Hotels h = hotelService.getHotelInfo(hotelName);
		if (h == null) {
			return new ResponseEntity<Hotels>(h, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(h, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/app1/admin/service/show/hotelInfoByStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Hotels>> getHotelInfoByStatus(@RequestParam("status") HotelStatus status) {

		List<Hotels> h = hotelService.getHotelsByStatus(status);
		if (h == null) {
			return new ResponseEntity<List<Hotels>>(h, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(h, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/app1/admin/service/show/HotelInfoRoomType", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Hotels>> getHotelInfoByStatus(@RequestParam("roomType") String roomType) {

		List<Hotels> h = hotelService.getAvailableHotelsByType(roomType);
		if (h == null) {
			return new ResponseEntity<List<Hotels>>(h, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(h, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/app1/admin/service/RegisteraNewHotel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Hotels> addHotel(@RequestBody Hotels hotels) throws Exception {
		Hotels hotel = hotelService.create(hotels);
		return new ResponseEntity(hotel, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/app1/admin/service/deRegisteredHotel", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteHotel(@RequestParam("hotelName") String hotelName) throws Exception {
		String s= hotelService.delete(hotelName);
		return new ResponseEntity(s+hotelName, HttpStatus.OK);
	}

	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
	 * String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	 * Map<String, String> errors = new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	 * ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
	 * errors; }
	 */

}
