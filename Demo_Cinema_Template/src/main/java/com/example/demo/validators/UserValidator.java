package com.example.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;

@Component("userValidator")
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		boolean checkU = false;
		boolean checkE = false;
		UserModel model = new UserModel();
		for (User u : model.findAllUser()) {
			if (u.getUsername().equals(user.getUsername()) && !u.getId().equals(user.getId())) {
				checkU = true;
			} else if (u.getEmail().equals(user.getEmail()) && !u.getId().equals(user.getId())) {
				checkE = true;
			}
		}
		if (checkU) {
			errors.rejectValue("username", "account.username.exists");
		}
		if (checkE) {
			errors.rejectValue("email", "account.email.exists");
		}

		  
		  if (!user.getPassword().equals(user.getConfirmPassword())) {
		  errors.rejectValue("confirmPassword", "confirmPassword.notequal"); }
		 
	}

}
