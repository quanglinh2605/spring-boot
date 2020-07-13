package com.example.demo.apis;

import java.util.List;

import com.example.demo.entities.Room;
import com.example.demo.entities.RoomEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RoomAPI {
	@GET("room/findall")
	Call<List<Room>> findall();

	@POST("room/create")
	Call<Room> create(@Body Room room);

	@PUT("room/update")
	Call<Room> update(@Body Room room);

	@DELETE("room/delete/{id}")
	Call<Void> delete(@Path("id") int id);

	@GET("room/getById/{id}")
	Call<Room> getById(@Path("id") int id);

	@GET("room/sortByCinema")
	Call<List<Room>> sortByCinema();

	@GET("room/search/{keyword}")
	Call<List<Room>> search(@Path("keyword") String keyword);

	@GET("room/listByCinemaId/{cinemaId}")
	Call<List<RoomEntity>> listByCinemaId(@Path("cinemaId") int cinemaId);
	
	@GET("room/listByCinema/{cinemaId}")
	Call<List<Room>> listByCinema(@Path("cinemaId") int cinemaId);
}
