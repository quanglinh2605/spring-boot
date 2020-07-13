package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Student;

@Repository("studentRepository")
public interface StudentRepository extends CrudRepository<Student, Integer> {
	@Query(value = "select * from student order by score desc limit :n", nativeQuery = true)
	public List<Student> bestScore(@Param("n") int n);
	
	@Query("from Student where month(birthday) = :month")
	public List<Student> findbymonth(@Param("month") int month);
}
