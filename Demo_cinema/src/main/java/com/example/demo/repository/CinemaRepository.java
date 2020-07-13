package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cinema;

@Repository("CinemaRepositories")
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {
	@Query("from Cinema where cinemaName like %:keyword% or cinemaAddress like %:keyword%")
	public List<Cinema> search(@Param("keyword") String keyword);
}
