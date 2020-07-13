package com.example.demo.apis;

import java.util.List;

import com.example.demo.entities.Movie;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MovieAPI {
	@GET("movie/findall")
	Call<List<Movie>> findAll();

	@GET("movie/findNewMovie")
	Call<Movie> findNewMovie();

	@GET("movie/findMovieById/{movie_id}")
	Call<Movie> findMovieById(@Path("movie_id") int movie_id);

	@GET("movie/findMovieByName/{movieName}")
	Call<Movie> findMovieByName(@Path("movieName") String movieName);

	@GET("movie/searchMovieName/{keyword}")
	Call<List<Movie>> searchMovieName(@Path("keyword") String keyword);
	
	// Linh

	@GET("movie/findall")
	Call<List<Movie>> findall();

	@POST("movie/create")
	Call<Movie> create(@Body Movie cinema);

	@PUT("movie/update")
	Call<Movie> update(@Body Movie cinema);

	@DELETE("movie/delete/{id}")
	Call<Void> delete(@Path("id") int id);

	@GET("movie/getById/{id}")
	Call<Movie> getById(@Path("id") int id);

	@GET("movie/search/{keyword}")
	Call<List<Movie>> search(@Path("keyword") String keyword);
}
