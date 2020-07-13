package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Seat;

@Repository("SeatRepositories")
public interface SeatRepository extends CrudRepository<Seat, Integer>{

	@Query("from Seat where row like %:row% and number = :number and room.roomId = :roomId")
	public List<Seat> findSeat(@Param("row") String row, @Param("number") int number, @Param("roomId") int roomId);
	
	@Query("from Seat where row like %:row% and number = :number order by room.roomId")
	public List<Seat> findSeat(@Param("row") String row, @Param("number") int number);
	
	@Query("from Seat where room_id = :roomId")
	public List<Seat> findByRoom(@Param("roomId") int roomId);
	
	@Query("from Seat as s order by s.room.roomId desc")
	public List<Seat> sortByCinemaRoom();
	
	//nghia
	@Query(value = "select * from Seats s where room_id = :room_id order by s.seat_id asc", nativeQuery = true)
	public List<Seat> findByRoomId(@Param("room_id") int room_id);
	
	@Query(value = "select * from Seats s where row = :row and room_id = :room_id", nativeQuery = true)
	public List<Seat> selectByRow(@Param("row") String row, @Param("room_id") int room_id);
	
	@Query(value = "select * from Seats s where seat_id = :seat_id", nativeQuery = true)
	public Seat findSeatById(@Param("seat_id") int seat_id);
}
