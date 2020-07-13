package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cinema;
import com.example.demo.repository.CinemaRepository;

@Service("cinimeService")
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinimeRepository;
	
	@Override
	public Iterable<Cinema> findAll() {
		return cinimeRepository.findAll();
	}

	@Override
	public Cinema save(Cinema cinema) {
		return cinimeRepository.save(cinema);
	}

	@Override
	public void delete(int id) {
		cinimeRepository.deleteById(id);
	}

	@Override
	public Cinema getByID(int id) {
		return cinimeRepository.findById(id).get();
	}

	@Override
	public List<Cinema> search(String keyword) {
		return cinimeRepository.search(keyword);
	}

}
