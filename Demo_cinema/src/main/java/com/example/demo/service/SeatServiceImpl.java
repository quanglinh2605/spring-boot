package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Seat;
import com.example.demo.repository.SeatRepository;

@Service("seatService")
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public Iterable<Seat> findAll() {
		// TODO Auto-generated method stub
		return seatRepository.findAll();
	}

	@Override
	public List<Seat> findByRoomId(int room_id) {
		// TODO Auto-generated method stub
		return seatRepository.findByRoomId(room_id);
	}

	@Override
	public Seat save(Seat seat) {
		// TODO Auto-generated method stub
		return seatRepository.save(seat);
	}

	@Override
	public void delete(int id) {
		seatRepository.deleteById(id);
	}

	@Override
	public Seat getByID(int id) {
		return seatRepository.findById(id).get();
	}

	@Override
	public List<Seat> search(String row, int number, int roomId) {		
		return seatRepository.findSeat(row, number, roomId);
	}

	@Override
	public List<Seat> search(String row, int number) {	
		return seatRepository.findSeat(row, number);
	}

	@Override
	public List<Seat> sortByCinemaRoom() {
		return seatRepository.sortByCinemaRoom();
	}

	@Override
	public List<Seat> selectByRow(String row, int room_id) {
		// TODO Auto-generated method stub
		return seatRepository.selectByRow(row, room_id);
	}

	@Override
	public Seat findSeatById(int seat_id) {
		// TODO Auto-generated method stub
		return seatRepository.findSeatById(seat_id);
	}

}
