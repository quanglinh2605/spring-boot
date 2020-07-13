package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.CinemaEntity;
import com.example.demo.repository.BookingRepository;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Iterable<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> findByMovieId(int schedule_id) {
		return bookingRepository.findByMovieId(schedule_id);
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> findByUser(int user_id) {
		return bookingRepository.findByUserId(user_id);
	}

	@Override
	public List<Booking> search(String keyword) {
		return bookingRepository.search(keyword);
	}

	@Override
	public List<Booking> listAll() {
		return bookingRepository.listall();
	}

	@Override
	public List<Booking> findByDate(String date) {
		return bookingRepository.findByDate(date);
	}

	@Override
	public List<Booking> bookingToday(String date) {
		return bookingRepository.bookingToday(date);
	}

	@Override
	public double total(String month) {
		return bookingRepository.total(month);
	}

	@Override
	public List<CinemaEntity> bestCinema(String month) {
		return bookingRepository.bestCinema(month);
	}

}
