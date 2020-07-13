
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cinema {

    @SerializedName("movie")
    @Expose
    private Movie movie;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("cinema")
    @Expose
    private Cinema_ cinema;
    @SerializedName("room")
    @Expose
    private Room room;
    @SerializedName("seat")
    @Expose
    private Seat seat;
    @SerializedName("schedule")
    @Expose
    private Schedule schedule;
    @SerializedName("booking")
    @Expose
    private Booking booking;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cinema_ getCinema() {
        return cinema;
    }

    public void setCinema(Cinema_ cinema) {
        this.cinema = cinema;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
