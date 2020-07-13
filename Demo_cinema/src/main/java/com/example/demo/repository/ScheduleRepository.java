package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Schedule;

@Repository("ScheduleRepositories")
public interface ScheduleRepository extends CrudRepository<Schedule, Integer>{

	@Query("from Schedule s where movie.movieName like %:keyword% or room.roomName like %:keyword% order by s.scheduleDate desc")
	public List<Schedule> search(@Param("keyword") String keyword);
	
	@Query(value="select * from schedule where schedule_date = :date", nativeQuery = true)
	public List<Schedule> findByDate(@Param("date") String date);
	
	@Query("from Schedule as s order by s.scheduleDate desc")
	public List<Schedule> sortByDate();
	
	//nghia
	@Query(value = "select * from Schedule s where movie_id = :movie_id and s.schedule_date LIKE Date(now() + INTERVAL :n DAY) and s.schedule_start >= ':now' order by s.schedule_date asc", nativeQuery = true)
	public List<Schedule> findByMovieId(@Param("movie_id") int movie_id, @Param("n") int n, @Param("now") String now);
	
	@Query(value = "select * from Schedule s where movie_id = :movie_id and room_id = :room_id and s.schedule_date LIKE Date(now() + INTERVAL :n DAY) and s.schedule_start >= ':now' order by s.schedule_start asc", nativeQuery = true)
	public List<Schedule> findByMovieAndRoom(@Param("movie_id") int movie_id, @Param("room_id") int room_id, @Param("n") int n, @Param("now") String now);

	@Query(value = "select * from Schedule s where schedule_id = :schedule_id", nativeQuery = true)
	public Schedule findByScheduleId(@Param("schedule_id") int schedule_id);
}
