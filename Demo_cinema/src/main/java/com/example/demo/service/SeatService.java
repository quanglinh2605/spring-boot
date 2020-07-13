package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Seat;

public interface SeatService {
	// Linh
	public Iterable<Seat> findAll();

	public Seat save(Seat seat);

	public void delete(int id);

	public Seat getByID(int id);

	public List<Seat> search(String row, int number, int roomId);

	public List<Seat> search(String row, int number);

	public List<Seat> sortByCinemaRoom();
	
	// nghia
	public List<Seat> findByRoomId(int room_id);
	
	public List<Seat> selectByRow(String row, int room_id);

	public Seat findSeatById(int seat_id);
}
