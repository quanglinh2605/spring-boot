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
import com.example.demo.entities.Schedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService service;

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Schedule>> findAll() {
		try {
			System.out.println("success!!");

			return new ResponseEntity<Iterable<Schedule>>(service.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Iterable<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "sortByDate", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> sortByDate() {
		try {
			return new ResponseEntity<List<Schedule>>(service.sortByDate(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findByMovie/{movie_id}/{n}/{now}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> findByMovie(@PathVariable("movie_id") int movie_id,
			@PathVariable("n") int n,
			@PathVariable("now") String now) {
		try {
			return new ResponseEntity<List<Schedule>>(service.findByMovieId(movie_id, n, now), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> create(@RequestBody Schedule Schedule) {
		try {
			System.out.println("success!!");

			return new ResponseEntity<Schedule>(service.save(Schedule), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Schedule>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> update(@RequestBody Schedule Schedule) {
		try {
			System.out.println("success!!");

			return new ResponseEntity<Schedule>(service.save(Schedule), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Schedule>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			service.delete(id);
			System.out.println("success!!");
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Schedule> getById(@PathVariable("id") int id) {
		try {
			System.out.println("success!!");
			return new ResponseEntity<Schedule>(service.getByID(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Schedule>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> search(@PathVariable("keyword") String keyword) {
		try {
			System.out.println("success!!");

			return new ResponseEntity<List<Schedule>>(service.search(keyword), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findByDate/{date}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> findByDate(@PathVariable("date") String date) {
		try {
			System.out.println("success!!");
			return new ResponseEntity<List<Schedule>>(service.findByDate(date), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	}

//nghia
	@RequestMapping(value = "findByMovieAndRoom/{movie_id}/{room_id}/{n}/{now}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Schedule>> findByMovieAndRoom(@PathVariable("movie_id") int movie_id,
			@PathVariable("room_id") int room_id,
			@PathVariable("n") int n,
			@PathVariable("now") String now) {
		try {
			return new ResponseEntity<List<Schedule>>(service.findByMovieAndRoom(movie_id, room_id, n, now), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findByScheduleId/{schedule_id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> findByScheduleId(@PathVariable("schedule_id") int schedule_id) {
		try {
			return new ResponseEntity<Schedule>(service.findScheduleId(schedule_id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + " dm ");
			return new ResponseEntity<Schedule>(HttpStatus.BAD_REQUEST);
		}
	}
}
