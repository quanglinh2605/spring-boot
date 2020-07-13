package com.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer>{
	@Query("from User where username = :username")
	public User findByUsername(@Param("username") String username);
}
