package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Room;
import com.example.demo.entities.RoomEntity;

@Repository("RoomRepositories")
public interface RoomRepository extends CrudRepository<Room, Integer> {
	@Query("from Room as r where roomName like %:keyword% or cinema.cinemaName like %:keyword% order by r.cinema.cinemaName desc")
	public List<Room> search(@Param("keyword") String keyword);

	@Query("select new com.example.demo.entities.RoomEntity(roomId, roomName) from Room where cinema.cinemaId = :cinemaId")
	public List<RoomEntity> listByCinemaId(@Param("cinemaId") int cinemaId);
	
	@Query("from Room where cinema.cinemaId = :cinemaId")
	public List<Room> listByCinema(@Param("cinemaId") int cinemaId);
	
	@Query("from Room as r order by r.cinema.cinemaName desc")
	public List<Room> sortByCinema();
}
