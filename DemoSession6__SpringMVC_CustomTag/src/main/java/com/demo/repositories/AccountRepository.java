package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Account;
@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer> {
	@Query("from Account where username = :username")
	public Account getByUsername(String username);
	
	@Query("from Account where password = :password")
	public Account checkPassword(String password);
	
	@Query(value = "select * from account where Date_Add(birthday, interval 25 year) <= Curdate()", nativeQuery = true)
	public List<Account> getByAge();
	
	@Query("from Account where month(birthday) = :month")
	public List<Account> getByMonth(int month);
		
}
