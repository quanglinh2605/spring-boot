package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Movie;

@Repository("MovieRepositories")
public interface MovieRepositories extends CrudRepository<Movie, Integer> {
	@Query("from Movie where movieName like %:keyword% or movieFormat like %:keyword%")
	public List<Movie> search(@Param("keyword") String keyword);
	
	//nghia
	@Query(value = "select * from Movie order by movie_id desc limit 0,1", nativeQuery = true)
	public Movie NewMovie();
	
	@Query(value = "select * from Movie where movie_id = :movie_id", nativeQuery = true)
	public Movie findMovieById(@Param("movie_id") int movie_id);
	
	@Query("from Movie where movieName like %:keyword%")
	public List<Movie> searchMovieName(@Param("keyword") String keyword);
	
	@Query("from Movie where movieName = :movieName")
	public Movie findMovieByName(@Param("movieName") String movieName);
}
