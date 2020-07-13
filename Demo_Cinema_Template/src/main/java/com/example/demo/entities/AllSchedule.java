package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

public class AllSchedule implements Serializable{

	private static final long serialVersionUID = 1L;
	private Movie movie;
	private List<ScheduleOut> schedules;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<ScheduleOut> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<ScheduleOut> schedules) {
		this.schedules = schedules;
	}
	public AllSchedule(Movie movie, List<ScheduleOut> schedules) {
		super();
		this.movie = movie;
		this.schedules = schedules;
	}
	public AllSchedule() {
		super();
	}
	
	
}
