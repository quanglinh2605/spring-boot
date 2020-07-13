package com.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.entities.Course;
import com.demo.entities.Faculty;
import com.demo.entities.Student;

public class StudentModel {
	public Student findStudent() {
		Student student = new Student("st01","Hoang Anh", "hoanganh@gmail.com","Hai Ba Trung");
		student.setFaculty(new Faculty("id", "Cong nghe thong tin"));
		student.setBirthday(new Date());
		student.getCourses().add(new Course("c01", "course 01", 10));
		student.getCourses().add(new Course("c02", "course 02", 10));
		student.getCourses().add(new Course("c03", "course 03", 10));
		return student;
	}
	public List<Student> findAll() {
		List<Student> students = new ArrayList<Student>();
		Student student = new Student("st01","Hoang Anh", "hoanganh@gmail.com","Hai Ba Trung");
		student.setFaculty(new Faculty("IT", "Cong nghe thong tin"));
		student.setBirthday(new Date());
		student.getCourses().add(new Course("c01", "course 01", 10));
		student.getCourses().add(new Course("c02", "course 02", 10));
		student.getCourses().add(new Course("c03", "course 03", 10));
		students.add(student);
		
		Student student2 = new Student("st02","Hoang Dieu", "hoangdieu@gmail.com","Hoang Dieu");
		student2.setFaculty(new Faculty("vl", "Vat Ly"));
		student2.setBirthday(new Date());
		student2.getCourses().add(new Course("c02", "course 02", 10));
		student2.getCourses().add(new Course("c04", "course 04", 8));
		student2.getCourses().add(new Course("c06", "course 06", 7));
		students.add(student2);
		
		Student student3 = new Student("st03","Hoang Ton", "hoangton@gmail.com","Nguyen Trai");
		student3.setFaculty(new Faculty("t", "Toan"));
		student3.setBirthday(new Date());
		student3.getCourses().add(new Course("c05", "course 05", 7));
		student3.getCourses().add(new Course("c03", "course 03", 9));
		student3.getCourses().add(new Course("c07", "course 07", 7));
		students.add(student3);
		return students;
	}
}
