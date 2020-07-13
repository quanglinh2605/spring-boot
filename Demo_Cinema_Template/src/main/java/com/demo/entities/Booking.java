package com.demo.entities;

public class Booking{
		
	    private int bookingId;	    
	    private User user;
	    private Schedule schedule;
	    private Seat seat;	    
	    private double price;
	    private int seatStatus;	    
	    private String combo_water;
	    private String bookingDate;
	    
	    
	    public String getBookingDate() {
	    	return bookingDate;
		}



		public void setBookingDate(String bookingDate) {
			this.bookingDate = bookingDate;
		}



		public String getCombo_water() {
			return combo_water;
		}



		public void setCombo_water(String combo_water) {
			this.combo_water = combo_water;
		}



		public Booking() {
	    }

	   

	    public int getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(int bookingId) {
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



		public Booking(int bookingId, User user, Schedule schedule, Seat seat, double price, int seatStatus, String combo_water) {
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
