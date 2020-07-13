package com.example.demo.entities;

import java.io.Serializable;

public class CinemaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cinema;
	private long bookingNumber;
		
	public CinemaEntity() {
		super();
	}
	public CinemaEntity(String cinema, long bookingNumber) {
		super();
		this.cinema = cinema;
		this.bookingNumber = bookingNumber;
	}
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public long getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(long bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	

}
