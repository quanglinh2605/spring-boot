package com.example.demo.entities;

public class Cols {
	
	private int seatId;
	private String colNumber;
	private String imgChar;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public String getColNumber() {
		return colNumber;
	}
	public void setColNumber(String colNumber) {
		this.colNumber = colNumber;
	}
	public String getImgChar() {
		return imgChar;
	}
	public void setImgChar(String imgChar) {
		this.imgChar = imgChar;
	}
	public Cols(int seatId, String colNumber, String imgChar) {
		super();
		this.seatId = seatId;
		this.colNumber = colNumber;
		this.imgChar = imgChar;
	}
	public Cols() {
		super();
	}
	
	
	

}
