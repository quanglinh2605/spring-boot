package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Booking;
import com.example.demo.entities.CinemaEntity;

public interface BookingService {

	public Iterable<Booking> findAll();
	
	public List<Booking> findByMovieId(int schedule_id);
	
	public List<Booking> findByUser(int user_id);
	
	public Booking save(Booking booking);
	
	public List<Booking> search(String keyword);
	
	public List<Booking> listAll();
	
	public List<Booking> findByDate(String date);
	
	public List<Booking> bookingToday(String date);
	
	public double total(String month);
	
	public List<CinemaEntity> bestCinema(String month);
}
