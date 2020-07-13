package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Room;
import com.example.demo.entities.RoomEntity;

public interface RoomService {

	public Iterable<Room> findAll();

	public Room save(Room Room);

	public void delete(int id);

	public Room getByID(int id);

	public List<Room> search(String keyword);

	public List<RoomEntity> findBycinemaId(int id);

	public List<Room> sortByCinema();
	
	public List<Room> listByCinema(int id);
}
