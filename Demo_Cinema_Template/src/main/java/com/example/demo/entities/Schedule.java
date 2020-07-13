
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("scheduleId")
    @Expose
    private String scheduleId;
    @SerializedName("movie")
    @Expose
    private Movie_ movie;
    @SerializedName("room")
    @Expose
    private Room__ room;
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

    public Movie_ getMovie() {
        return movie;
    }

    public void setMovie(Movie_ movie) {
        this.movie = movie;
    }

    public Room__ getRoom() {
        return room;
    }

    public void setRoom(Room__ room) {
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
