package com.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("demo")
public class DemoController {
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(HttpSession session) {
	session.setAttribute("age", 20);
	session.setAttribute("username", "buonngu");
	return "demo/index";
 }
	@RequestMapping(value = {"","remove"}, method = RequestMethod.GET)
	public String remove(HttpSession session) {
		session.removeAttribute("age");
		return "demo/index";
	}
}
