package com.example.demo.apis;

import java.util.List; 

import com.example.demo.entities.Cinema;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CinemaAPI {
	@GET("cinema/findall")
	Call<List<Cinema>> findall();
	@POST("cinema/create")
	Call<Cinema> create(@Body Cinema cinema);
	@PUT("cinema/update")
	Call<Cinema> update(@Body Cinema cinema);
	@DELETE("cinema/delete/{id}")
	Call<Void> delete(@Path("id") int id);
	@GET("cinema/getById/{id}")
	Call<Cinema> getById(@Path("id") int id);
	@GET("cinema/search/{keyword}")
	Call<List<Cinema>> search(@Path("keyword") String keyword); 
}
