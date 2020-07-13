package com.example.demo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.UserAPI;
import com.example.demo.entities.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserAPI api = APIClient.getClient().create(UserAPI.class);
		User user = null;
		try {
			user = api.findByUsername(username).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(user == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(user.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		if(user.getRole().equalsIgnoreCase("ROLE_USER")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}
}
