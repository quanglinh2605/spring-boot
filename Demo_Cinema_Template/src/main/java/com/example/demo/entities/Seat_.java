
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seat_ {

    @SerializedName("seat_id")
    @Expose
    private String seatId;
    @SerializedName("seat_type")
    @Expose
    private String seatType;
    @SerializedName("room")
    @Expose
    private Room____ room;
    @SerializedName("row")
    @Expose
    private String row;
    @SerializedName("number")
    @Expose
    private String number;

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSratType(String seatType) {
        this.seatType = seatType;
    }

    public Room____ getRoom() {
        return room;
    }

    public void setRoom(Room____ room) {
        this.room = room;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
