package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Movie;
import com.example.demo.repository.MovieRepositories;

@Service("MovieService")
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepositories movieRepositories;
	
	@Override
	public Iterable<Movie> findAll() {
		return movieRepositories.findAll();
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepositories.save(movie);
	}

	@Override
	public void delete(int id) {
		movieRepositories.deleteById(id);
	}

	@Override
	public Movie getByID(int id) {
		return movieRepositories.findById(id).get();
	}

	@Override
	public List<Movie> search(String keyword) {
		// TODO Auto-generated method stub
		return movieRepositories.search(keyword);
	}

	@Override
	public Movie findNewMovie() {
		// TODO Auto-generated method stub
		return movieRepositories.NewMovie();
	}

	@Override
	public Movie findMovieById(int movie_id) {
		// TODO Auto-generated method stub
		return movieRepositories.findMovieById(movie_id);
	}

	@Override
	public Movie findMovieByName(String movieName) {
		return movieRepositories.findMovieByName(movieName);
	}

	@Override
	public List<Movie> searchMovieName(String movieName) {
		return movieRepositories.searchMovieName(movieName);
	}

}
