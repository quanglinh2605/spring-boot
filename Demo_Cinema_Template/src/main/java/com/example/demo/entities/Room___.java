
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Room___ {

    @SerializedName("roomId")
    @Expose
    private String roomId;
    @SerializedName("cinema")
    @Expose
    private Cinema_____ cinema;
    @SerializedName("roomName")
    @Expose
    private String roomName;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Cinema_____ getCinema() {
        return cinema;
    }

    public void setCinema(Cinema_____ cinema) {
        this.cinema = cinema;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
