package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Account;
import com.demo.repositories.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account getByUsername(String username) {
		return accountRepository.getByUsername(username);
	}

	@Override
	public Account checkPassword(String password) {
		return accountRepository.checkPassword(password);
	}

	@Override
	public List<Account> getByMonth(int month) {
		return accountRepository.getByMonth(month);
	}

	@Override
	public List<Account> getByAge() {
		return accountRepository.getByAge();
	}

	@Override
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

	
}
