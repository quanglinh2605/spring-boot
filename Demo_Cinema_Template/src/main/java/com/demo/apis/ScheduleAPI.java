package com.demo.apis;

import java.util.List;

import com.demo.entities.Schedule;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ScheduleAPI {
	@GET("schedule/findall")
	Call<List<Schedule>> findall();

	@GET("schedule/sortByDate")
	Call<List<Schedule>> sortByDate();

	@POST("schedule/create")
	Call<Schedule> create(@Body Schedule Schedule);

	@PUT("schedule/update")
	Call<Schedule> update(@Body Schedule Schedule);

	@DELETE("schedule/delete/{id}")
	Call<Void> delete(@Path("id") int id);

	@GET("schedule/getById/{id}")
	Call<Schedule> getById(@Path("id") int id);

	@GET("schedule/search/{keyword}")
	Call<List<Schedule>> search(@Path("keyword") String keyword);

	@GET("schedule/findByDate/{date}")
	Call<List<Schedule>> findByDate(@Path("date") String date);

	@GET("schedule/findByMovie/{movie_id}")
	Call<List<Schedule>> findByMovie(@Path("movie_id") int movie_id);
}
