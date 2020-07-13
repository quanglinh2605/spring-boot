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

import com.example.demo.entities.Movie;
import com.example.demo.service.MovieService;

@RestController
@RequestMapping("api/movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Movie> > findAll(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Iterable<Movie>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Movie>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "create", method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> create(@RequestBody Movie Movie){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Movie>(service.save(Movie), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> update(@RequestBody Movie Movie){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Movie>(service.save(Movie), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
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
	public ResponseEntity<Movie> getById(@PathVariable("id") int id){
		try {
			System.out.println("success!!");
			return new ResponseEntity<Movie>(service.getByID(id) ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Movie> > search(@PathVariable("keyword") String keyword){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Movie>>(service.search(keyword), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Movie>>(HttpStatus.BAD_REQUEST);
		}
	}
	//Nghia
	@RequestMapping(value = "findNewMovie", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Movie> NewMovie(){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Movie>(service.findNewMovie(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findMovieById/{movie_id}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Movie> findMovieById(@PathVariable("movie_id") int movie_id){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Movie>(service.findMovieById(movie_id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findMovieByName/{movieName}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Movie> findMovieByName(@PathVariable("movieName") String movieName){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<Movie>(service.findMovieByName(movieName), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "searchMovieName/{movieName}", method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Movie> > searchMovieName(@PathVariable("movieName") String movieName){
		try {
			System.out.println("success!!");
			
			return new ResponseEntity<List<Movie>>(service.searchMovieName(movieName), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Movie>>(HttpStatus.BAD_REQUEST);
		}
	}
}
