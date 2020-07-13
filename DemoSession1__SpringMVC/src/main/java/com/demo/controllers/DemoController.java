package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//http://localhost:9596
//http://localhost:9596/demo
//http://localhost:9596/demo/index
@Controller
@RequestMapping(value = { "", "demo" })
public class DemoController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index() {
		return "demo/index";
	}

	@RequestMapping(value = "index2", method = RequestMethod.GET)
	public String index2(ModelMap modelMap) {
		modelMap.put("age", 20);
		modelMap.put("username", "abc");
		modelMap.put("status", true);
		modelMap.put("price", 4.5);
		return "demo/index2";
	}

	@RequestMapping(value = "index3/{id}", method = RequestMethod.GET)
	public String index3(@PathVariable("id") String id) {
		System.out.println("id: " + id);
		return "demo/index3";
	}

	@RequestMapping(value = "index4/{id1}/{id2}", method = RequestMethod.GET)
	public String index4(@PathVariable("id1") String id1, @PathVariable("id2") int id2) {
		System.out.println("id1: " + id1);
		System.out.println("id2: " + id2);
		return "demo/index3";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("keyword") String keyword, 
			@RequestParam("price") double price,
			@RequestParam("quantity") int[] quantities) {
		System.out.println(keyword);
		System.out.println(price);
		for(int quantity : quantities) {
			System.out.println(quantity);
		}
		return "redirect:/product/index";
	}

}
