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
@Table(name = "room")
public class Room implements Serializable {	 
	private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "room_id")
	    private int roomId;

	 	@ManyToOne
		@JoinColumn(name = "cinema_id")
		private Cinema cinema;

	    @Column(name = "room_name ")
	    private String roomName;

	    public Room() {
			super();
		}

		public Room(int roomId, Cinema cinema, String roomName) {
			super();
			this.roomId = roomId;
			this.cinema = cinema;
			this.roomName = roomName;
		}

		public Room(int roomId, String roomName) {
			super();
			this.roomId = roomId;
			this.roomName = roomName;
		}

		@OneToMany(targetEntity = Room.class, mappedBy = "college", fetch = FetchType.EAGER)
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "cinema_id", nullable = false)
	    public Cinema getCinema() {
			return cinema;
		}

	    @OneToMany(targetEntity = Room.class, mappedBy = "college", fetch = FetchType.EAGER)
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
