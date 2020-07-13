package com.demo.services;

import java.util.List;

import com.demo.entities.Student;

public interface StudentService {
	public List<Student> findbymonth(int month);
	public Student find(int id);
	public List<Student> bestScore(int n);
}
