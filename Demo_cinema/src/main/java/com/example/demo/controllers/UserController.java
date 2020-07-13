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

import com.example.demo.entities.Users;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Users> > findAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Iterable<Users>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Users>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "create", method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> create(@RequestBody Users Users){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Users>(service.save(Users), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> update(@RequestBody Users Users){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Users>(service.save(Users), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
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
	public ResponseEntity<Users> getById(@PathVariable("id") int id){
		try {
			System.out.println("success!!");
			return new ResponseEntity<Users>(service.getByID(id) ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findByUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<Users> getById(@PathVariable("username") String username){
		try {
			System.out.println("success!!");
			return new ResponseEntity<Users>(service.findByUsername(username) ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Users> > search(@PathVariable("keyword") String keyword){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Users>>(service.search(keyword), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Users>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "listAll", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Users> > listAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Users>>(service.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Users>>(HttpStatus.BAD_REQUEST);
		}
	}
}
