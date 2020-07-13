	package com.demo.entities;

import javax.validation.constraints.NotEmpty;

public class Cinema{

	    private int cinemaId;
	    
	    @NotEmpty
	    private String cinemaName;
	    
	    @NotEmpty
	    private String cinemaAddress;
	    
	    public Cinema() {
	    }

	    public Cinema(String cinemaName, String cinemaAddress) {
	        this.cinemaName = cinemaName;
	        this.cinemaAddress = cinemaAddress;
	    }
	    
	    	    public Cinema(int cinemaId, String cinemaName, String cinemaAddress) {
			super();
			this.cinemaId = cinemaId;
			this.cinemaName = cinemaName;
			this.cinemaAddress = cinemaAddress;
		}

		public int getCinemaId() {
	        return cinemaId;
	    }

	    public void setCinemaId(int cinemaId) {
	        this.cinemaId = cinemaId;
	    }

	    public String getCinemaName() {
	        return cinemaName;
	    }

	    public void setCinemaName(String cinemaName) {
	        this.cinemaName = cinemaName;
	    }

	    public String getCinemaAddress() {
	        return cinemaAddress;
	    }

	    public void setCinemaAddress(String cinemaAddress) {
	        this.cinemaAddress = cinemaAddress;
	    }
}
