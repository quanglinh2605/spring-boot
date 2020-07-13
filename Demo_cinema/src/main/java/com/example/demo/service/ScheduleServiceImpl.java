package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Schedule;
import com.example.demo.repository.ScheduleRepository;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Override
	public Iterable<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	@Override
	public List<Schedule> findByMovieId(int movie_id, int n, String now) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByMovieId(movie_id, n, now);
	}

	@Override
	public Schedule save(Schedule Schedule) {
		return scheduleRepository.save(Schedule);
	}

	@Override
	public void delete(int id) {
		scheduleRepository.deleteById(id);
	}

	@Override
	public Schedule getByID(int id) {
		return scheduleRepository.findById(id).get();
	}

	@Override
	public List<Schedule> search(String keyword) {	
		return scheduleRepository.search(keyword);
	}

	@Override
	public List<Schedule> findByDate(String date) {	
		return scheduleRepository.findByDate(date);
	}

	@Override
	public List<Schedule> sortByDate() {
		return scheduleRepository.sortByDate();
	}

	@Override
	public List<Schedule> findByMovieAndRoom(int movie_id, int room_id, int n, String now) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByMovieAndRoom(movie_id, room_id, n , now);
	}

	@Override
	public Schedule findScheduleId(int schedule_id) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByScheduleId(schedule_id);
	}
}
