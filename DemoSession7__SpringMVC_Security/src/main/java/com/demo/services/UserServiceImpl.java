package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entities.*;
import com.demo.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(UserRole userRole: user.getUserRoles()) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findbyUsername(String username) {
		return userRepository.findByUsername(username);
	}

	
}
