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

import com.example.demo.entities.Seat;
import com.example.demo.service.SeatService;

@RestController
@RequestMapping("api/seat")
public class SeatController {
	
	@Autowired
	private SeatService service;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Seat> > findAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Iterable<Seat>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Seat>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findByRoom/{room_id}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Seat> > findByRoom(@PathVariable("room_id") int room_id){
		try {
			return new ResponseEntity<List<Seat>>(service.findByRoomId(room_id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Seat>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "sortByCinemaRoom", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Seat> > sortByCinemaRoom(){
		try {
			return new ResponseEntity<List<Seat>>(service.sortByCinemaRoom(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Seat>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seat> create(@RequestBody Seat Seat){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Seat>(service.save(Seat), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Seat>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seat> update(@RequestBody Seat Seat){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Seat>(service.save(Seat), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Seat>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		try {
			service.delete(id);
			System.out.println("success!!");
			return new ResponseEntity<Void>( HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Seat> getById(@PathVariable("id") int id){
		try {
			System.out.println("success!!");
			return new ResponseEntity<Seat>(service.getByID(id) ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Seat>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{row}/{number}/{roomId}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Seat> > search(@PathVariable("row") String row, @PathVariable("number") int number, @PathVariable("roomId") int roomId){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Seat>>(service.search(row, number, roomId), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Seat>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{row}/{number}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Seat> > search(@PathVariable("row") String row, @PathVariable("number") int number){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Seat>>(service.search(row, number), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Seat>>(HttpStatus.BAD_REQUEST);
		}
	}
	//nghia
	@RequestMapping(value = "selectByRow/{room_id}/{row}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Seat> > selectByRow(@PathVariable("row") String row, @PathVariable("room_id") int room_id){
		try {
			return new ResponseEntity<List<Seat>>(service.selectByRow(row, room_id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Seat>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findSeatById/{seat_id}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Seat> findSeatById(@PathVariable("seat_id") int seat_id){
		try {
			return new ResponseEntity<Seat>(service.findSeatById(seat_id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<Seat>(HttpStatus.BAD_REQUEST);
		}
	}
}
