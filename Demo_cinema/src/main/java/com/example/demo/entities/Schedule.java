package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable{

	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "schedule_id")
	    private int scheduleId;

	 	@ManyToOne
		@JoinColumn(name = "movie_id")
	 	private Movie movie;

	 	@ManyToOne
	 	@JoinColumn(name = "room_id")
	 	private Room room;

	    @Column(name = "schedule_date")
	    private String scheduleDate;

	    @Column(name = "schedule_start")
	    private String scheduleStart;

	    @Column(name = "schedule_end")
	    private String scheduleEnd;

		public int getScheduleId() {
			return scheduleId;
		}

		public void setScheduleId(int scheduleId) {
			this.scheduleId = scheduleId;
		}

		
		@OneToMany(targetEntity = Movie.class, mappedBy = "college", fetch = FetchType.EAGER)
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "movie_id", nullable = false)
		public Movie getMovie() {
			return movie;
		}
		
		@OneToMany(targetEntity = Movie.class, mappedBy = "college", fetch = FetchType.EAGER)
		public void setMovie(Movie movie) {
			this.movie = movie;
		}

		@OneToMany(targetEntity = Room.class, mappedBy = "college", fetch = FetchType.EAGER)
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "room_id", nullable = false)
		public Room getRoom() {
			return room;
		}

		@OneToMany(targetEntity = Room.class, mappedBy = "college", fetch = FetchType.EAGER)
		public void setRoom(Room room) {
			this.room = room;
		}

		public String getScheduleDate() {
			return scheduleDate;
		}

		public void setScheduleDate(String scheduleDate) {
			this.scheduleDate = scheduleDate;
		}

		public String getScheduleStart() {
			return scheduleStart;
		}

		public void setScheduleStart(String scheduleStart) {
			this.scheduleStart = scheduleStart;
		}

		public String getScheduleEnd() {
			return scheduleEnd;
		}

		public void setScheduleEnd(String scheduleEnd) {
			this.scheduleEnd = scheduleEnd;
		}
	
	    
	    
}
