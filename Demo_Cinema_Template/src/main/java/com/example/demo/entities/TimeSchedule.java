package com.example.demo.entities;
public class TimeSchedule{

	private int id;
	private String scheduleTime;
	private int seatAvailable;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	public TimeSchedule(int id, String scheduleTime, int seatAvailable) {
		super();
		this.id = id;
		this.scheduleTime = scheduleTime;
		this.seatAvailable = seatAvailable;
	}
	public TimeSchedule() {
		super();
	}
	
	
}
