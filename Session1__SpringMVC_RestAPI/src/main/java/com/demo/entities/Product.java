package com.demo.entities;

public class Product {
	private String id;
	private String name;
	private double price;
	private boolean status;
	private int quantity;
	
	
	public Product() {
		super();
	}
	public Product(String id, String name, double price, boolean status, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
