package com.example.demo.controllers.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.apis.BookingAPI;
import com.demo.entities.Booking;
import com.example.demo.apis.APIClient;
import com.example.demo.apis.UserAPI;
import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.validators.UserValidator;

@Controller
@RequestMapping("account")
public class AccountController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = { "", "details" }, method = RequestMethod.GET)
	public String details(ModelMap modelMap, HttpServletRequest request) {
		User user = new User();
		user = (User) request.getSession().getAttribute("currentUser");
		if(user == null) {
			return "redirect:/login";
		}
		modelMap.put("title", "UserInfo | Cinema XXII");
		modelMap.put("user", new UserModel().getByUsername(user.getUsername()));
		return "account.details";
	}

	@RequestMapping(value = "change", method = RequestMethod.GET)
	public String changeInfo(ModelMap modelMap, HttpServletRequest request) {
		User user = new User();
		user = (User) request.getSession().getAttribute("currentUser");
		if(user == null) {
			return "redirect:/login";
		}
		modelMap.put("title", "Update | Cinema XXII");
		modelMap.put("user", new UserModel().getByUsername(user.getUsername()));
		return "account.change";
	}

	@RequestMapping(value = "change", method = RequestMethod.POST)
	public String changeInfo(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
		UserAPI api = APIClient.getClient().create(UserAPI.class);	
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "account.change";
		}else {
			try {
				User item = api.getById(Integer.parseInt(user.getId())).execute().body();
				if (user.getPassword() == "" || user.getPassword().isEmpty()) {
					user.setPassword(item.getPassword());
				} else {
					user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
				}
				if (file == null) {
					user.setAvatar(item.getAvatar());
				}else {
					user.setAvatar(upload(file));
				}
				user.setPoint("0");
				api.update(user).execute().body();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/account/details";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("currentUser", null);
		return "redirect:/login";
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

	@RequestMapping(value = { "booking" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("bookings", null);
		return "redirect:/account/page/1";
	}
	
	@RequestMapping(value = {"page/{pageNumber}"})
	public String showBookingPage(HttpServletRequest request, 
			@PathVariable int pageNumber, ModelMap modelMap) {
		int d;
		if(request.getSession().getAttribute("d") != null) {
			d = (int) request.getSession().getAttribute("d");
		}else {
			d = 0;
		}
		if(pageNumber == 1) {
			d++;
			request.getSession().setAttribute("d", d);
		}
		if(pageNumber != 1 || d != 1) {
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("type",null);
			request.getSession().setAttribute("d", null);
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("bookings");
		int pagesize = 3;
		BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		List<Booking> list = null;
		try {
			User user = new User();
			user = (User) request.getSession().getAttribute("currentUser");
			list = (List<Booking>) bookingAPI.findByUser(Integer.parseInt(user.getId())).execute().body();
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
		request.getSession().setAttribute("bookings", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1; 
		int end = totalPageCount < 5 ? totalPageCount : begin + 4 ;	
		String baseUrl = "/account/page/";
		
		modelMap.put("title", "Booking | Cinema XXII");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("bookings", pages);

		return "account.booking";
	}
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
