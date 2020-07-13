package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.User;
import com.demo.entities.UserRole;
import com.demo.entities.UserRolePK;
import com.demo.services.RoleService;
import com.demo.services.UserRoleService;
import com.demo.services.UserService;

@Controller
@RequestMapping("dashboard")
public class DashBoardController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "success", required = false) String success, ModelMap modelMap) {
		if (error != null) {
			modelMap.put("msg", "Invalid");
		}
		if (success != null) {
			modelMap.put("msg", "Logout Successful");
		}
		return "dashboard/index";
	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome(Authentication authentication) {
		System.out.println("Username: " + authentication.getName());
		return "dashboard/welcome";
	}

	@RequestMapping(value = "accessdenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "dashboard/accessdenied";
	}

	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String report() {
		return "dashboard/report";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("user", new User());
		modelMap.put("roles", roleService.findAll());
		return "dashboard/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, @RequestParam("roles") int[] roles) {

		String hash = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(hash);
		user = userService.save(user);

		if (roles != null && roles.length > 0) {
			for (int roleId : roles) {
				UserRole userRole = new UserRole();
				userRole.setId(new UserRolePK(user.getId(), roleId));
				userRole.setEnable(true);
				userRoleService.save(userRole);
			}
		}

		return "redirect:/dashboard/index";
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Authentication authentication, ModelMap modelMap) {
		modelMap.put("user", userService.findByUsername(authentication.getName()));
		modelMap.put("roles", roleService.findAll());
		return "dashboard/profile";
	}

	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute("user") User user, @RequestParam("roles") int[] roles) {

		User currentUser = userService.findByUsername(user.getUsername());

		if (!user.getPassword().isEmpty()) {
			String hash = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(hash);
		} else {
			user.setPassword(currentUser.getPassword());
		}
		user = userService.save(user);

		if (roles != null && roles.length > 0) {
			List<UserRole> userRoles = userRoleService.findByUsername(user.getUsername());
			if (userRoles != null) {
				for (UserRole userRole : userRoleService.findByUsername(user.getUsername())) {
					userRoleService.delete(userRole);
				}
			}

			for (int roleId : roles) {
				UserRole userRole = new UserRole();
				userRole.setId(new UserRolePK(user.getId(), roleId));
				userRole.setEnable(true);
				userRoleService.save(userRole);
			}
		}

		return "redirect:/dashboard/profile";
	}

}
