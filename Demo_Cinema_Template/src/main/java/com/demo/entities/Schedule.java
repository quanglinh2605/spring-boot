package com.demo.entities;

public class Schedule{

	    private int scheduleId;
	 	
	    private Movie movie;
	 	
	    private Room room;
	    
	    private String scheduleDate;
	    
	    private String scheduleStart;
	    
	    private String scheduleEnd;

		public int getScheduleId() {
			return scheduleId;
		}

		public void setScheduleId(int scheduleId) {
			this.scheduleId = scheduleId;
		}

		
		public Movie getMovie() {
			return movie;
		}
		
		public void setMovie(Movie movie) {
			this.movie = movie;
		}

		public Room getRoom() {
			return room;
		}

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
