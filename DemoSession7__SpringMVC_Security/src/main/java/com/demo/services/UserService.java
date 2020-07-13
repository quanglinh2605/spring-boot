package com.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.entities.User;

public interface UserService extends UserDetailsService {
	public User save(User user);
	public User findbyUsername(String username);
}
