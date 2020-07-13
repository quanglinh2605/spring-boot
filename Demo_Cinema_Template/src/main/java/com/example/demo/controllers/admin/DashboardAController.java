package com.example.demo.controllers.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.apis.APIClient;
import com.demo.apis.UserAPI;

@Controller
@RequestMapping(value = {"/manage","dashboard"})
public class DashboardAController {
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "success", required = false) String success, ModelMap modelMap,HttpServletRequest request) {
		modelMap.put("title", "Login");
		if (error != null) {
			modelMap.put("msg", "Invalid");
		}
		if (success != null) {
			request.getSession().setAttribute("user", null);;
			modelMap.put("msg", "Logout Successful");
		}
		return "dashboard/index";
	}
	
	@RequestMapping(value = {"welcome"}, method = RequestMethod.GET)
	public String welcome(Authentication authentication, ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		request.getSession().setAttribute("d", null);
		System.out.println("Username:" + authentication.getName());
		UserAPI userAPI = APIClient.getClient().create(UserAPI.class);
		try {
			request.getSession().setAttribute("user", userAPI.findByUsername(authentication.getName()).execute().body());
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelMap.put("title", "Welcome");
		return "dashboard.welcome";
	}

	@RequestMapping(value = "accessdenied", method = RequestMethod.GET)
	public String accessdenied() {
		return "dashboard/accessdenied";
	}
}
