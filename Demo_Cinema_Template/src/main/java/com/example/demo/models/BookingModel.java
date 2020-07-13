package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.BookingAPI;
import com.example.demo.entities.Booking;

public class BookingModel {
	
	List<Booking> bookings = null;
	
	public List<Booking> findByScheduleId(int schedule_id){
		BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		try {
			bookings = new ArrayList<Booking>();
			bookings = bookingAPI.findBySchedule(schedule_id).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bookings;
	}
	
	public List<Booking> findByUserId(int user_id){
		BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		try {
			bookings = new ArrayList<Booking>();
			bookings = bookingAPI.findByUser(user_id).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bookings;
	}
	
	public void book(Booking booking) {
		BookingAPI api = APIClient.getClient().create(BookingAPI.class);
		try {
			api.booking(booking);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " loi book");
		}
	}

}
