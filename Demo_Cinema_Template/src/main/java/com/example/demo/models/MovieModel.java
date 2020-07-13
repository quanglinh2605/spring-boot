package com.example.demo.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.MovieAPI;
import com.example.demo.entities.Movie;

public class MovieModel {

	private Movie movie= null;
	private List<Movie> movies = null;
	
	public List<Movie> findAllMovie(){
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			movies = new ArrayList<Movie>();
			movies = movieAPI.findAll().execute().body();
		} catch (IOException e) {
			// TODO  Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return movies;
	}
	
	public Movie findNewMovie() {
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			movie = new Movie();
			movie = movieAPI.findNewMovie().execute().body();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return movie;
	}
	public Movie findMovieById(int movie_id) {
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			movie = new Movie();
			movie = movieAPI.findMovieById(movie_id).execute().body();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return movie;
	}
	public Movie findMovieByName(String movieName) {
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			movie = new Movie();
			movie = movieAPI.findMovieByName(movieName).execute().body();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return movie;
	}
}
