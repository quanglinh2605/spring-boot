package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Users;

public interface UserService {

	public Iterable<Users> findAll();

	public Users save(Users user);

	public void delete(int id);

	public Users getByID(int id);

	public List<Users> search(String keyword);

	public Users findByUsername(String username);
	
	public List<Users> listAll();
}
