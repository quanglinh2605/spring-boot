package com.demo.controllers.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/superadmin/report**")
public class ReportController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index() {
		return "report/index";
	}

}
