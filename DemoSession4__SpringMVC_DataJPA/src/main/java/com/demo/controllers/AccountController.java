package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Account;
import com.demo.services.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("accounts", accountService.findAll());
		return "account/index";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(ModelMap modelMap, @RequestParam("keyword") String keyword) {
		modelMap.put("account", accountService.getByUsername(keyword));
		return "account/index2";
	}
	
	@RequestMapping(value = "listbymonth", method = RequestMethod.POST)
	public String listbymonth(ModelMap modelMap, @RequestParam("month") int month) {
		modelMap.put("accounts", accountService.getByMonth(month));
		return "account/index";
	}
	@RequestMapping(value = "listbyAge",method = RequestMethod.GET)
	public String listbyAge(ModelMap modelMap) {
		modelMap.put("accounts", accountService.getByAge());
		return "account/index";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap modelMap,@RequestParam("username") String username, @RequestParam("password") String password) {
		Account account = accountService.getByUsername(username);
		if(account == null) {
			modelMap.put("msg", "Username is wrong");
		}
		else{
			if(account.getPassword().equalsIgnoreCase(password)) {
				modelMap.put("username",account.getUsername());
				return "account/success";
			}
			else {
				modelMap.put("msg", "Password is wrong");
			}
		}
		modelMap.put("accounts", accountService.findAll());
		return "account/index";
	}
}
