package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;

@Repository("UserRepositories")
public interface UsersRepositories extends CrudRepository<Users, Integer> {
	@Query("from Users where username like %:keyword% or fullname like %:keyword% or email like %:keyword% or city like %:keyword% order by role desc")
	public List<Users> search(@Param("keyword") String keyword);
	
	@Query("from Users where username = :username")
	public Users findByUsername(@Param("username") String username);
	
	@Query("from Users order by role desc")
	public List<Users> listAll();
}
