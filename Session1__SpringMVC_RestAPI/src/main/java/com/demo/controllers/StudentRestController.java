package com.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Student;
import com.demo.models.StudentModel;

@RestController
@RequestMapping("api/student")
public class StudentRestController {
	@RequestMapping(value = "find", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<Student> find() {
		try {
			StudentModel studentModel = new StudentModel();
			return new ResponseEntity<Student>(studentModel.findStudent(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Student>> findAll() {
		try {
			StudentModel studentModel = new StudentModel();
			return new ResponseEntity<List<Student>>(studentModel.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(HttpStatus.BAD_REQUEST);
		}
	}
}
