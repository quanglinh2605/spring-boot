package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.UserRole;
import com.demo.repositories.UserRoleRepository;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService
{
	@Autowired
	private UserRoleRepository UserRoleRepository;
	@Override
	public UserRole save(UserRole userRole) {
		return UserRoleRepository.save(userRole);
	}
	@Override
	public void delete(UserRole role) {
		UserRoleRepository.delete(role);
	}
	@Override
	public List<UserRole> findbyUsername(String username) {
		// TODO Auto-generated method stub
		return UserRoleRepository.findByUsername(username);
	}
	
}
