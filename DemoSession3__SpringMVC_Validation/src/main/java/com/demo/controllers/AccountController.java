package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entities.Account;
import com.demo.validators.AccountValidator;

@Controller
@RequestMapping(value = { "", "account" })
public class AccountController {

	@Autowired
	private AccountValidator accountValidator;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("account", new Account());
		return "account/index";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		accountValidator.validate(account, bindingResult);
		if (bindingResult.hasErrors()) {
			return "account/index";
		} else {
			System.out.println("username: " + account.getUsername());
			return "account/success";
		}
	}

}
