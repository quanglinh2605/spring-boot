package com.demo.services;

import java.util.List;

import com.demo.entities.UserRole;

public interface UserRoleService {

	public UserRole save(UserRole userRole);
	
	public void delete(UserRole userRole);
	
	public List<UserRole> findByUsername(String username);

}
