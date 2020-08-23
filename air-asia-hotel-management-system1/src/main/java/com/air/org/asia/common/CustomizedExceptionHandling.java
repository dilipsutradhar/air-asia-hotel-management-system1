package com.air.org.asia.common;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.air.org.asia.exception.BookingNotFoundException;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(BookingNotFoundException.class)
	    public ResponseEntity<Object> handleExceptions( BookingNotFoundException exception, WebRequest webRequest) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage("Not found");
	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	        return entity;
	    }

}
