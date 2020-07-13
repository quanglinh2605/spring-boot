package com.example.demo.apis;

import java.util.List;

import com.example.demo.entities.Booking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookingAPI {
	@GET("booking/findall")
	Call<List<Booking>> findall();
	
	@GET("booking/search/{keyword}")
	Call<List<Booking>> search(@Path("keyword") String keyword);

	@GET("booking/findBySchedule/{schedule_id}")
    Call<List<Booking>> findBySchedule(@Path("schedule_id") int schedule_id);

    @GET("booking/findByUser/{user_id}")
    Call<List<Booking>> findByUser(@Path("user_id") int user_id);

    @POST("booking/create_booking")
    Call<Booking> booking(@Body Booking booking);
    
    @GET("booking/findByDate/{date}")
	Call<List<Booking>> findByDate(@Path("date") String date);
}
