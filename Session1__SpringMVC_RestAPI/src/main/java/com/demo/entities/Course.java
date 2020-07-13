package com.demo.entities;

public class Course {
	private String id;
	private String name;
	private double score;
	
	public Course() {
		super();
	}
	public Course(String id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
