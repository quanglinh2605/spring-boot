package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepositories;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepositories usersRepositories;

	@Override
	public Iterable<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepositories.findAll();
	}

	@Override
	public Users save(Users user) {
		// TODO Auto-generated method stub
		return usersRepositories.save(user);
	}

	@Override
	public void delete(int id) {
		usersRepositories.deleteById(id);
	}

	@Override
	public Users getByID(int id) {
		return usersRepositories.findById(id).get();
	}

	@Override
	public List<Users> search(String keyword) {
		return usersRepositories.search(keyword);
	}

	@Override
	public Users findByUsername(String username) {
		return usersRepositories.findByUsername(username);
	}

	@Override
	public List<Users> listAll() {
		return usersRepositories.listAll();
	}

}
