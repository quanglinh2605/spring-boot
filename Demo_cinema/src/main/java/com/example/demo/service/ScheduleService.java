package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Schedule;

public interface ScheduleService {

	public Iterable<Schedule> findAll();

	public Schedule save(Schedule Schedule);

	public void delete(int id);

	public Schedule getByID(int id);

	public List<Schedule> search(String keyword);

	public List<Schedule> findByDate(String date);

	public List<Schedule> sortByDate();

	// nghia
	public List<Schedule> findByMovieId(int movie_id, int n, String now);

	public List<Schedule> findByMovieAndRoom(int movie_id, int room_id, int n, String now);

	public Schedule findScheduleId(int schedule_id);
}
