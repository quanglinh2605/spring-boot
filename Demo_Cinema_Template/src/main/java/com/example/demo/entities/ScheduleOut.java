package com.example.demo.entities;

import java.util.List;

public class ScheduleOut {

	private String nameCinema;
	private String room;
	private List<TimeSchedule> timeschedule;
	public String getNameCinema() {
		return nameCinema;
	}
	public void setNameCinema(String nameCinema) {
		this.nameCinema = nameCinema;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public List<TimeSchedule> getTimeschedule() {
		return timeschedule;
	}
	public void setTimeschedule(List<TimeSchedule> timeschedule) {
		this.timeschedule = timeschedule;
	}
	public ScheduleOut(String nameCinema, String room, List<TimeSchedule> timeschedule) {
		super();
		this.nameCinema = nameCinema;
		this.room = room;
		this.timeschedule = timeschedule;
	}
	public ScheduleOut() {
		super();
	}
	
	
	
	
}
