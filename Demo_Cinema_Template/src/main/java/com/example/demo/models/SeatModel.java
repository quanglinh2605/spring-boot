package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.SeatsAPI;
import com.example.demo.entities.Seat;

public class SeatModel {
List<Seat> seats = null;
	Seat seat = null;
	public List<Seat> findByRoomId(int room_id){
		SeatsAPI seatsAPI = APIClient.getClient().create(SeatsAPI.class);
		try {
			seats = new ArrayList<Seat>();
			seats = seatsAPI.findByRoom(room_id).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return seats;
	}
	
	public List<Seat> selectByRow(String row, int room_id){
		SeatsAPI seatsAPI = APIClient.getClient().create(SeatsAPI.class);
		try {
			seats = new ArrayList<Seat>();
			seats = seatsAPI.selectByRow(row, room_id).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return seats;
	}
	
	public Seat findSeatById(int seat_id){
		SeatsAPI seatsAPI = APIClient.getClient().create(SeatsAPI.class);
		try {
			seat = new Seat();
			seat = seatsAPI.findSeat(seat_id).execute().body();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return seat;
	}
}
