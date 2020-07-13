package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.ScheduleAPI;
import com.example.demo.entities.Schedule;

public class ScheduleModel {

	private List<Schedule> schedules = null;
	private Schedule schedule = null;
	
	public List<Schedule> findAll(){
		ScheduleAPI api= APIClient.getClient().create(ScheduleAPI.class);
		try {
			schedules = new ArrayList<Schedule>();
			schedules = api.findAll().execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return schedules;
	}
	
	public List<Schedule> findScheduleByMovie(int movie_id, int n, String now){
		ScheduleAPI api = APIClient.getClient().create(ScheduleAPI.class);
		try {
			schedules = new ArrayList<Schedule>();
			schedules = api.findByMovie(movie_id, n, now).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return schedules;
		
	}
	
	public List<Schedule> findScheduleByMovieRoom(int movie_id, int room_id, int n, String now){
		ScheduleAPI api = APIClient.getClient().create(ScheduleAPI.class);
		try {
			schedules = new ArrayList<Schedule>();
			schedules = api.findByMovieAndRoom(movie_id, room_id, n , now).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return schedules;
		
	}
	
	public Schedule findSchedule(int schedule_id) {
		ScheduleAPI api = APIClient.getClient().create(ScheduleAPI.class);
		try {
			schedule = new Schedule();
			schedule = api.findByScheduleId(schedule_id).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return schedule;
	}
}
