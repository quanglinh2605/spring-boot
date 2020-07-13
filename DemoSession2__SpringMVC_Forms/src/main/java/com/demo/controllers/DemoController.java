package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("demo")
public class DemoController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(@RequestParam("username") String username, 
			@RequestParam("password") String password ,
			HttpSession session,
			HttpServletRequest request) {
		session.setAttribute("age", 20);
		session.setAttribute("username", "abc");
		return "demo/index";
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String remove(HttpSession session) {
		session.removeAttribute("age");
		return "demo/index";
	}

}
