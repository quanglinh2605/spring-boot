package com.example.demo.controllers.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.UserAPI;
import com.example.demo.entities.User;
import com.example.demo.validators.UserValidator;

@Controller
@RequestMapping("/user/users")
public class UserController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String change(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("user", request.getSession().getAttribute("user"));
		modelMap.put("title", "User");
		return "users.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String change(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, ModelMap modelMap,
			@RequestParam("file") MultipartFile file) {
		UserAPI api = APIClient.getClient().create(UserAPI.class);
		user.setConfirmPassword(user.getPassword());
		if (user.getRole() == null) {
			user.setRole("ROLE_USER");
		}
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			modelMap.put("title", "User");
			return "users.edit";
		} else {
			User item = new User();
			try {
				item = api.getById(Integer.parseInt(user.getId())).execute().body();
				if (user.getPassword() != "" || !user.getPassword().isEmpty()) {
					String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
					user.setPassword(hash);
				}
				if (file == null) {
					user.setAvatar(item.getAvatar());
				} else {
					user.setAvatar(upload(file));
				}
				api.update(user).execute();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/user/users/details";
		}
	}

	@RequestMapping(value = "details", method = RequestMethod.GET)
	public String details(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("user", request.getSession().getAttribute("user"));
		modelMap.put("title", "User");
		return "users.details";
	}

	public String upload(MultipartFile mu) {
		try {
			byte[] bytes = mu.getBytes();

			Path path = Paths.get(servletContext.getRealPath("/uploads/images/" + mu.getOriginalFilename()));
			Files.write(path, bytes);
			return mu.getOriginalFilename();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
