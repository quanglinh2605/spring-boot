package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Role;

@Repository(value = "roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
}
