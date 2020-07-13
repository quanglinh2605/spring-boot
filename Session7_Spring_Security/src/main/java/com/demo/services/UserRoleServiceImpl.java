package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.UserRole;
import com.demo.repositories.UserRoleRepository;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserRole save(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public void delete(UserRole userRole) {
		userRoleRepository.delete(userRole);
	}

	@Override
	public List<UserRole> findByUsername(String username) {
		return userRoleRepository.findByUsername(username);
	}

}
