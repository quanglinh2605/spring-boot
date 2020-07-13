package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Movie;

public interface MovieService {

	public Iterable<Movie> findAll();

	public Movie save(Movie movie);

	public void delete(int id);

	public Movie getByID(int id);

	public List<Movie> search(String keyword);

	public Movie findNewMovie();

	public Movie findMovieById(int movie_id);
	
	public Movie findMovieByName(String movieName);
	
	public List<Movie> searchMovieName(String movieName);
}
