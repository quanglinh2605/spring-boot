
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Booking {

	@SerializedName("bookingId")
	@Expose
	private String bookingId;
	@SerializedName("user")
	@Expose
	private User user;
	@SerializedName("schedule")
	@Expose
	private Schedule schedule;
	@SerializedName("seat")
	@Expose
	private Seat seat;
	@SerializedName("price")
	@Expose
	private String price;
	@SerializedName("seatStatus")
	@Expose
	private String seatStatus;

	@SerializedName("combo_water")
	@Expose
	private String comboWater;

	@SerializedName("bookingDate")
	@Expose
	private String bookingDate;

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getComboWater() {
		return comboWater;
	}

	public void setComboWater(String comboWater) {
		this.comboWater = comboWater;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

}
