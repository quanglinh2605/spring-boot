package com.demo.apis;

import java.util.List;

import com.demo.entities.Booking;
import com.demo.entities.CinemaEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReportAPI {
	@GET("report/bookingToday/{date}")
	Call<List<Booking>> bookingToday(@Path("date")String date);
	
	@GET("report/total/{month}")
	Call<Double> total(@Path("month") String month);
	
	@GET("report/bestCinema/{month}")
	Call<List<CinemaEntity>> bestCinema(@Path("month") String month);
}
