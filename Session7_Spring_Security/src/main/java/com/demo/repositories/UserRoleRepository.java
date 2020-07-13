package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.UserRole;
import com.demo.entities.UserRolePK;

@Repository("userRoleRepository")
public interface UserRoleRepository extends CrudRepository<UserRole, UserRolePK> {

	@Query("from UserRole where user.username = :username")
	public List<UserRole> findByUsername(@Param("username") String username);
	
}
