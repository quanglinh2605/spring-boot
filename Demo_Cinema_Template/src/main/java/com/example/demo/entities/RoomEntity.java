package com.example.demo.entities;

import java.io.Serializable;

public class RoomEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int roomId;
	private String roomName;
	
	public RoomEntity() {
		super();
	}
	public RoomEntity(int roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
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
