package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("api/booking")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Booking> > findAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Iterable<Booking>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("failse!!");
			return new ResponseEntity<Iterable<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "listall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Booking> > listall(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Booking>>(service.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("failse!!");
			return new ResponseEntity<List<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Booking> > search(@PathVariable("keyword") String keyword){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Booking>>(service.search(keyword), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("failse!!");
			return new ResponseEntity<List<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findBySchedule/{schedule_id}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Booking> > findByMovie(@PathVariable("schedule_id") int schedule_id){
		try {
			return new ResponseEntity<List<Booking>>(service.findByMovieId(schedule_id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "findByUser/{user_id}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Booking> > findByUser(@PathVariable("user_id") int user_id){
		try {
			return new ResponseEntity<List<Booking>>(service.findByUser(user_id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "findByDate/{date}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Booking>> findByUser(@PathVariable("date") String date){
		try {
			return new ResponseEntity<List<Booking>>(service.findByDate(date), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Booking>>(HttpStatus.BAD_REQUEST);
		}
	}
	//create
		@RequestMapping(value = "create_booking", method = RequestMethod.POST,
				consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
				produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<Booking> create(@RequestBody Booking booking){
			try {
				
				return new ResponseEntity<Booking>(service.save(booking), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
			}
		}
		
		
		
}
