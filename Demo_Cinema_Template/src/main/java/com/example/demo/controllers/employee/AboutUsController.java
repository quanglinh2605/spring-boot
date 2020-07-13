package com.example.demo.controllers.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "aboutus"})
public class AboutUsController {

	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "About us | Cinema XXII" );
		return "aboutus.index";
	}
}
