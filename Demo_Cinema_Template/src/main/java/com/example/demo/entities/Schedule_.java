
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule_ {

    @SerializedName("scheduleId")
    @Expose
    private String scheduleId;
    
    @SerializedName("movie")
    @Expose
    private Movie__ movie;
    @SerializedName("room")
    @Expose
    private Room___ room;
    @SerializedName("scheduleDate")
    @Expose
    private String scheduleDate;
    @SerializedName("scheduleStart")
    @Expose
    private String scheduleStart;
    @SerializedName("scheduleEnd")
    @Expose
    private String scheduleEnd;

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Movie__ getMovie() {
        return movie;
    }

    public void setMovie(Movie__ movie) {
        this.movie = movie;
    }

    public Room___ getRoom() {
        return room;
    }

    public void setRoom(Room___ room) {
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
