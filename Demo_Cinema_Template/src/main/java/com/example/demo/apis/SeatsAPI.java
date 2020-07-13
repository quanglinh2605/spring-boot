package com.example.demo.apis;

import java.util.List;

import com.example.demo.entities.Seat;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SeatsAPI {

	@GET("seat/findByRoom/{room_id}")
	Call<List<Seat>> findByRoom(@Path("room_id") int room_id);

	@GET("seat/selectByRow/{room_id}/{row}")
	Call<List<Seat>> selectByRow(@Path("row") String row, @Path("room_id") int room_id);

	@GET("seat/findSeatById/{seat_id}")
	Call<Seat> findSeat(@Path("seat_id") int seat_id);

	// Linh
	@GET("seat/findall")
	Call<List<Seat>> findall();

	@POST("seat/create")
	Call<Seat> create(@Body Seat Seat);

	@PUT("seat/update")
	Call<Seat> update(@Body Seat Seat);

	@DELETE("seat/delete/{id}")
	Call<Void> delete(@Path("id") int id);

	@GET("seat/getById/{id}")
	Call<Seat> getById(@Path("id") int id);

	@GET("seat/search/{row}/{number}/{roomId}")
	Call<List<Seat>> search(@Path("row") String row, @Path("number") int number, @Path("roomId") int roomId);

	@GET("seat/sortByCinemaRoom")
	Call<List<Seat>> sortByCinemaRoom();
	
	@GET("seat/search/{row}/{number}")
	Call<List<Seat>> search(@Path("row") String row,@Path("number") int number); 
}
