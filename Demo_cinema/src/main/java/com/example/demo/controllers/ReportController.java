package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking;
import com.example.demo.entities.CinemaEntity;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("api/report")
public class ReportController {
	
	@Autowired
	private BookingService service;
	
	@RequestMapping(value = "bookingToday/{date}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Booking>> BookingToday(@PathVariable("date") String date){
		try {
			System.out.println("success!!");
		
			return new ResponseEntity<List<Booking>>(service.bookingToday(date), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("failse!!");
			return new ResponseEntity<List<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "total/{month}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.TEXT_PLAIN_VALUE )
	public ResponseEntity<String> total(@PathVariable("month") String month){
		try {
			System.out.println("success!!");
			double total = service.total(month);
			return new ResponseEntity<String>(String.valueOf(total), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("failse!!");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "bestCinema/{month}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CinemaEntity>> bestCinema(@PathVariable("month") String month){
		try {
			System.out.println("success!!");
			return new ResponseEntity<List<CinemaEntity>>(service.bestCinema(month), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("failse!!");
			return new ResponseEntity<List<CinemaEntity>>(HttpStatus.BAD_REQUEST);
		}
	}
}
