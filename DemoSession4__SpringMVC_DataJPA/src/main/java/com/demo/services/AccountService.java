package com.demo.services;

import java.util.List;

import com.demo.entities.Account;

public interface AccountService {
	public Account getByUsername(String username);
	public Account checkPassword(String password);
	public List<Account> getByMonth(int month);
	public List<Account> getByAge();
	public Iterable<Account> findAll();
}
