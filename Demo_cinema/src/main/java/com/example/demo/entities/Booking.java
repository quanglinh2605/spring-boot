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
@Table(name = "booking")
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@ManyToOne
	@JoinColumn(name = "seat_id")
	private Seat seat;

	@Column(name = "price")
	private double price;

	@Column(name = "seat_status")
	private int seatStatus;

	@Column(name = "combo_water")
	private String combo_water;

	@Column(name = "booking_date")
	private String bookingDate;

	public String getCombo_water() {
		return combo_water;
	}

	public void setCombo_water(String combo_water) {
		this.combo_water = combo_water;
	}

	public Booking() {
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@OneToMany(targetEntity = Users.class, mappedBy = "college", fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUser() {
		return user;
	}

	@OneToMany(targetEntity = Users.class, mappedBy = "college", fetch = FetchType.EAGER)
	public void setUser(Users user) {
		this.user = user;
	}

	@OneToMany(targetEntity = Schedule.class, mappedBy = "college", fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id", nullable = false)
	public Schedule getSchedule() {
		return schedule;
	}

	@OneToMany(targetEntity = Schedule.class, mappedBy = "college", fetch = FetchType.EAGER)
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@OneToMany(targetEntity = Seat.class, mappedBy = "college", fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seat_id", nullable = false)
	public Seat getSeat() {
		return seat;
	}

	@OneToMany(targetEntity = Seat.class, mappedBy = "college", fetch = FetchType.EAGER)
	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(int seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Booking(int bookingId, Users user, Schedule schedule, Seat seat, double price, int seatStatus,
			String combo_water) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.schedule = schedule;
		this.seat = seat;
		this.price = price;
		this.seatStatus = seatStatus;
		this.combo_water = combo_water;
	}

}
