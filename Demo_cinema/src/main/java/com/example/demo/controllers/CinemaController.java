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

import com.example.demo.entities.Cinema;
import com.example.demo.service.CinemaService;

@RestController
@RequestMapping("api/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaService service;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Cinema>> findAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Iterable<Cinema>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Iterable<Cinema>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cinema> create(@RequestBody Cinema cinema){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Cinema>(service.save(cinema), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cinema>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cinema> update(@RequestBody Cinema cinema){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Cinema>(service.save(cinema), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cinema>(HttpStatus.BAD_REQUEST);
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
	public ResponseEntity<Cinema> getById(@PathVariable("id") int id){
		try {
			System.out.println("success!!");
			return new ResponseEntity<Cinema>(service.getByID(id) ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cinema>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Cinema> > search(@PathVariable("keyword") String keyword){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Cinema>>(service.search(keyword), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Cinema>>(HttpStatus.BAD_REQUEST);
		}
	}
}
