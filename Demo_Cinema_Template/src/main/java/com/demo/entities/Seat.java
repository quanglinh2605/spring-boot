package com.demo.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class Seat {
	
	private int seat_id;
	private int seat_type;
	private boolean checked;
	
	private Room room;
	
	@NotEmpty
	private String row;
	
	@Min(0)
	private int number;
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getseat_type() {
		return seat_type;
	}
	
	public void setseat_type(int seat_type) {
		this.seat_type = seat_type;
	}
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
