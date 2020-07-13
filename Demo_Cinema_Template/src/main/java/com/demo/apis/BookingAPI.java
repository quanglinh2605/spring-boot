package com.demo.apis;

import java.util.List;

import com.demo.entities.Booking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookingAPI {
	@GET("booking/findall")
	Call<List<Booking>> findall();
	
	@GET("booking/findBySchedule/{schedule_id}")
	Call<List<Booking>> findBySchedule(@Path("scheduleId") int schedule_id);
	
	@GET("booking/findByUser/{user_id}")
	Call<List<Booking>> findByUser(@Path("user_id") int user_id);
	
	@GET("booking/search/{keyword}")
	Call<List<Booking>> search(@Path("keyword") String keyword);
	
	@GET("booking/listall")
	Call<List<Booking>> listall();
	
	@GET("booking/findByDate/{date}")
	Call<List<Booking>> findByDate(@Path("date") String date);
}
