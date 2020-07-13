package com.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.entities.Account;

@Component("accountValidator")
public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Account.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Account account = (Account) object;
		if (account.getUsername().equalsIgnoreCase("abc")) {
			errors.rejectValue("username", "account.username.exists");
		}
	}

}
