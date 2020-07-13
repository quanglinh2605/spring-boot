package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Role;

public class RoleModel {
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("r1", "role 1"));
		roles.add(new Role("r2", "role 2"));
		roles.add(new Role("r3", "role 3"));
		roles.add(new Role("r4", "role 4"));
		roles.add(new Role("r5", "role 5"));
		return roles;
	}
}
