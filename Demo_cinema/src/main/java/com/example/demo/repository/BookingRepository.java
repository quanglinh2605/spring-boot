package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Booking;
import com.example.demo.entities.CinemaEntity;

@Repository("BookingRepositories")
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	@Query(value = "select * from Booking b where schedule_id = :schedule_id order by b.booking_id desc", nativeQuery = true)
	public List<Booking> findByMovieId(@Param("schedule_id") int schedule_id);

	@Query(value = "select * from Booking b where user_id = :user_id order by b.booking_id desc", nativeQuery = true)
	public List<Booking> findByUserId(@Param("user_id") int user_id);

	@Query("from Booking where user.fullname like %:keyword% order by bookingId desc")
	public List<Booking> search(@Param("keyword") String keyword);

	@Query("from Booking where bookingDate = :date order by bookingId desc")
	public List<Booking> findByDate(@Param("date") String date);

	@Query("from Booking order by bookingId desc")
	public List<Booking> listall();

	@Query("from Booking where booking_date = :date")
	public List<Booking> bookingToday(@Param("date") String date);

	@Query("select SUM(price) from Booking where cast(month(cast(bookingDate as date)) as string) like %:month%")
	public double total(@Param("month") String month);

	@Query("select new com.example.demo.entities.CinemaEntity(b.seat.room.cinema.cinemaName, COUNT(b.bookingId)) from Booking as b where cast(month(cast(b.bookingDate as date)) as string) like %:month% group by b.seat.room.cinema.cinemaName order by COUNT(b.bookingId) desc")
	public List<CinemaEntity> bestCinema(@Param("month") String month);
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    