package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Student;
import com.demo.repositories.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findbymonth(int month) {
		return studentRepository.findbymonth(month);
	}

	@Override
	public Student find(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> bestScore(int n) {
		return studentRepository.bestScore(n);
	}

}
