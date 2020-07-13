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

import com.example.demo.entities.Room;
import com.example.demo.entities.RoomEntity;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("api/room")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Room> > findAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Iterable<Room>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Iterable<Room>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "sortByCinema", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Room> > sortByCinema(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Room>>(service.sortByCinema(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Room>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "listByCinemaId/{cinemaId}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<RoomEntity>> listByCinemaId(@PathVariable("cinemaId") int cinemaId){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<RoomEntity>>(service.findBycinemaId(cinemaId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<RoomEntity>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "listByCinema/{cinemaId}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Room>> listByCinema(@PathVariable("cinemaId") int cinemaId){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Room>>(service.listByCinema(cinemaId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Room>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Room> create(@RequestBody Room Room){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Room>(service.save(Room), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Room>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Room> update(@RequestBody Room Room){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Room>(service.save(Room), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Room>(HttpStatus.BAD_REQUEST);
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
	public ResponseEntity<Room> getById(@PathVariable("id") int id){
		try {
			System.out.println("success!!");
			return new ResponseEntity<Room>(service.getByID(id) ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Room>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Room> > search(@PathVariable("keyword") String keyword){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Room>>(service.search(keyword), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Room>>(HttpStatus.BAD_REQUEST);
		}
	}
}
