package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Student;
import com.demo.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentRestController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "findbymonth/{month}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> findbymonth(@PathVariable("month") int month) {
		try {
			return new ResponseEntity<List<Student>>(studentService.findbymonth(month), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "bestScore/{n}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> bestScore(@PathVariable("n") int n) {
		try {
			return new ResponseEntity<List<Student>>(studentService.bestScore(n), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findbyid/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> findbyid(@PathVariable("id") int id) {
		try {
			String xeploai = "";
			Student student = studentService.find(id);
			if (student.getScore() > 8) {
				xeploai = "gioi";
			} else if (student.getScore() > 6.5) {
				xeploai = "kha";
			} else if (student.getScore() > 5) {
				xeploai = "trung binh";
			} else {
				xeploai = "yeu";
			}
			return new ResponseEntity<String>(xeploai, HttpStatus.OK);
		} catch (

		Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
