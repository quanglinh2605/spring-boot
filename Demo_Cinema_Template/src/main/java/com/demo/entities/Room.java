package com.demo.entities;

import javax.validation.constraints.NotEmpty;

public class Room {
	  private int roomId;
	  	
	 	private Cinema cinema;
	    
	 	@NotEmpty
	 	private String roomName;
	    
	 	
	 	public Room() {
	    }
	    public Cinema getCinema() {
			return cinema;
		}

		public void setCinema(Cinema cinema) {
			this.cinema = cinema;
		}


		public int getRoomId() {
	        return roomId;
	    }

	    public void setRoomId(int roomId) {
	        this.roomId = roomId;
	    }


	    public String getRoomName() {
	        return roomName;
	    }

	    public void setRoomName(String roomName) {
	        this.roomName = roomName;
	    }
}
