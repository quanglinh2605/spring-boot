package com.example.demo.controllers.employee;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.example.demo.models.UserModel;
import com.example.demo.validators.UserValidator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Controller
@RequestMapping(value = {"login"})
public class LoginController implements ServletContextAware{
	
	private ServletContext servletContext;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private UserValidator userValidatior;

	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title","Login");
		return "login.index";
		
		
	}
	@RequestMapping(value = "sigin", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user,
			ModelMap modelMap, HttpServletRequest session) {
		UserModel usermodel = new UserModel();
		List<User> users = usermodel.findAllUser();
		for(User u : users) {
			if(user.getUsername().equalsIgnoreCase(u.getUsername()) && 
					BCrypt.checkpw(user.getPassword(), u.getPassword())) {
				session.getSession().setAttribute("currentUser", u);
				return "redirect:/home/index";
			}else {
				modelMap.put("errLogin", "username or password is not match!!");
			}
		}
			
		return "login.index";
	}
	
	@RequestMapping(value = {"index2"}, method = RequestMethod.GET)
	public String index2(ModelMap map) {
		map.put("user", new User());
		return "login.index2";
		
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult,
			@RequestParam("file") MultipartFile file, ModelMap modelMap ) {
		
		userValidatior.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "login.index2";
		}
		else {
			String photo = upload(file);
			System.out.println(photo + " src photo");
			user.setAvatar(photo);
			user.setPoint("0");
			String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hash);
			try {
			UserAPI api = APIClient.getClient().create(UserAPI.class);
			api.create(user).enqueue(new Callback<User>() {
				
				@Override
				public void onResponse(Call<User> call, Response<User> response) {
					// TODO Auto-generated method stub
					try {
						System.out.println("Status code: " + response.code());
						System.out.println("Is success: " + response.isSuccessful());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				@Override
				public void onFailure(Call<User> call, Throwable t) {
					// TODO Auto-generated method stub
					System.out.println(t.getMessage());
				}
			});
			}catch (Exception e) {
				System.out.println(e.getMessage() + "lỗi");
			}
			modelMap.put("title", "Register");
			return "redirect:/login/index";
			
		}
		
	}

	@RequestMapping(value = {"index3"}, method = RequestMethod.GET)
	public String index3(ModelMap map) {
		map.put("user", new User());
		return "login.index3";
		
	}
	@RequestMapping(value = {"f_pass"}, method = RequestMethod.POST)
	public String f_pass(@RequestParam("mail") String mail) {
		UserModel model = new UserModel();
		List<User> users = model.findAllUser();
		for(User u : users) {
			if(u.getEmail().equalsIgnoreCase(mail)){
				SimpleMailMessage message = new SimpleMailMessage();
			      String from = "nghiadeptrai001@gmail.com";
				 	System.out.println(mail);
		            message.setFrom(from);
			        message.setTo(mail);
			        message.setSubject("forgot pass");
			        message.setText("hi your password is " + u.getPassword());
			        
			        // Send Message!
			        this.emailSender.send(message);
				
				return "login.index4";
			}
		}

		return "login.index4";
		
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
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
	}

}
