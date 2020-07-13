package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Cinema;

public interface CinemaService {

	public Iterable<Cinema> findAll();
	public Cinema save(Cinema cinema);
	public void delete(int id);
	public Cinema getByID(int id);
	public List<Cinema> search(String keyword);
}
