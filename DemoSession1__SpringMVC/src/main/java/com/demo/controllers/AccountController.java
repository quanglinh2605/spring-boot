package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("account")
public class AccountController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "account/index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password, ModelMap modelMap) {
		if (username.equalsIgnoreCase("abc") && password.equalsIgnoreCase("123")) {
			modelMap.put("username", username);
			return "account/welcome";
		} else {
			modelMap.put("msg", "Invalid");
			return "account/index";
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/account/login";
	}

}
