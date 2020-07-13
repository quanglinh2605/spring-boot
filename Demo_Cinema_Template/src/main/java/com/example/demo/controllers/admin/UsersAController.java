package com.example.demo.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.User;
import com.example.demo.validators.UserValidator;
import com.example.demo.apis.APIClient;
import com.example.demo.apis.UserAPI;

@Controller
@RequestMapping(value = { "/admin/users" })
public class UsersAController{

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("users", null);
		return "redirect:/admin/users/page/1";
	}

	@RequestMapping(value = { "page/{pageNumber}" })
	public String showUserPage(HttpServletRequest request, @PathVariable int pageNumber, ModelMap modelMap) {
		int d;
		if (request.getSession().getAttribute("d") != null) {
			d = (int) request.getSession().getAttribute("d");
		} else {
			d = 0;
		}
		if (pageNumber == 1) {
			d++;
			request.getSession().setAttribute("d", d);
		}
		if (pageNumber != 1 || d != 1) {
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("type", null);
			request.getSession().setAttribute("d", null);
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("users");
		int pagesize = 3;
		UserAPI userAPI = APIClient.getClient().create(UserAPI.class);
		List<User> list = null;
		try {
			list = (List<User>) userAPI.listAll().execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("users", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/users/page/";

		modelMap.put("title", "User");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("users", pages);

		return "users.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		modelMap.put("title", "User");
		modelMap.put("user", new User());
		return "users.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
		String path = "redirect:/admin/users/index";
		user.setConfirmPassword(user.getPassword());
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Add Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);
			modelMap.put("title", "User");
			return "users.add";
		} else {
			try {
				user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
				UserAPI UserAPI = APIClient.getClient().create(UserAPI.class);
				User result = UserAPI.create(user).execute().body();
				if (Integer.parseInt(result.getId()) != 0) {
					request.getSession().setAttribute("message", "Added Successfully");
					request.getSession().setAttribute("type", "alert-success");
					request.getSession().setAttribute("d", null);
					modelMap.put("title", "User");
					path = "redirect:/admin/users/index";
				} else {
					path = "users.add";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return path;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		UserAPI UserAPI = APIClient.getClient().create(UserAPI.class);
		try {
			UserAPI.delete(id).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/users/index";
	}

	@RequestMapping(value = "details/{id}", method = RequestMethod.GET)
	public String details(@PathVariable("id") int id, ModelMap modelMap) {
		UserAPI UserAPI = APIClient.getClient().create(UserAPI.class);
		try {
			modelMap.put("user", UserAPI.getById(id).execute().body());
			modelMap.put("title", "User");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "users.details";
	}

	@RequestMapping(value = "reset/{id}", method = RequestMethod.GET)
	public String resetPassword(@PathVariable("id") int id, HttpServletRequest request, ModelMap modelMap) {
		UserAPI userAPI = APIClient.getClient().create(UserAPI.class);
		User user = new User();
		try {
			user = userAPI.getById(id).execute().body();
			String hash = BCrypt.hashpw("12345678", BCrypt.gensalt());
			user.setPassword(hash);
			userAPI.update(user).execute();
			request.getSession().setAttribute("message", "Reset Successfully");
			request.getSession().setAttribute("type", "alert-success");
			request.getSession().setAttribute("d", null);
			modelMap.put("title", "User");
		} catch (IOException e) {
			request.getSession().setAttribute("message", "Reset Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);
			e.printStackTrace();
		}
		return "redirect:/admin/users/index";
	}

	@RequestMapping(value = { "search/{page}" }, method = RequestMethod.GET)
	public String search(ModelMap modelMap, @RequestParam("keyword") String keyword, HttpServletRequest request,
			@PathVariable("page") int page) {
		if (keyword.equals("")) {
			return "redirect:/admin/users/index";
		}
		UserAPI userAPI = APIClient.getClient().create(UserAPI.class);
		List<User> list = null;
		try {
			list = userAPI.search(keyword).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list == null) {
			return "redirect:/admin/users/index";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("users");
		int pagesize = 3;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		final int goToPage = page - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
		request.getSession().setAttribute("users", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/users/search/";
		modelMap.addAttribute("beginIndex", begin);
		modelMap.addAttribute("endIndex", end);
		modelMap.addAttribute("currentIndex", current);
		modelMap.addAttribute("totalPageCount", totalPageCount);
		modelMap.addAttribute("baseUrl", baseUrl);
		modelMap.addAttribute("users", pages);
		modelMap.put("title", "User");
		modelMap.put("keyword", keyword);
		modelMap.put("addUrl", "?keyword=" + keyword);
		return "users.index";
	}	
}
