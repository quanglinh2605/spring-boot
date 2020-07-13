package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Room;
import com.example.demo.entities.RoomEntity;
import com.example.demo.repository.RoomRepository;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Iterable<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public Room save(Room Room) {
		return roomRepository.save(Room);
	}

	@Override
	public void delete(int id) {
		roomRepository.deleteById(id);
	}

	@Override
	public Room getByID(int id) {
		return roomRepository.findById(id).get();
	}

	@Override
	public List<Room> search(String keyword) {
		return roomRepository.search(keyword);
	}

	@Override
	public List<RoomEntity> findBycinemaId(int id) {
		return roomRepository.listByCinemaId(id);
	}

	@Override
	public List<Room> sortByCinema() {
		return roomRepository.sortByCinema();
	}

	@Override
	public List<Room> listByCinema(int id) {
		return roomRepository.listByCinema(id);
	}

}
