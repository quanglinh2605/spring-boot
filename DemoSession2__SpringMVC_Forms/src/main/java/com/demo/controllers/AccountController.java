package com.demo.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.Account;
import com.demo.models.CertificateModel;
import com.demo.models.DepartmentModel;
import com.demo.models.RoleModel;

@Controller
@RequestMapping(value = { "", "account" })
public class AccountController implements ServletContextAware {

	private ServletContext servletContext;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		CertificateModel certificateModel = new CertificateModel();
		RoleModel roleModel = new RoleModel();
		DepartmentModel departmentModel = new DepartmentModel();
		modelMap.put("certificates", certificateModel.findAll());
		modelMap.put("roles", roleModel.findAll());
		modelMap.put("departments", departmentModel.findAll());

		Account account = new Account();
		account.setId(123);
		account.setUsername("abc");
		account.setGender("m");
		account.setCertificate("c2");
		account.setRoles(new String[] { "r1", "r2", "r4" });
		modelMap.put("account", account);
		return "account/index";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("account") Account account, 
			@RequestParam("file") MultipartFile file) {
		System.out.println("username: " + account.getUsername());
		System.out.println("password: " + account.getPassword());
		System.out.println("Description: " + account.getDescription());
		System.out.println("gender: " + account.getGender());
		System.out.println("status: " + account.isStatus());
		System.out.println("Roles:");
		for (String role : account.getRoles()) {
			System.out.println("\t" + role);
		}
		System.out.println("department: " + account.getDepartment());
		System.out.println("id: " + account.getId());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("birthday: " + simpleDateFormat.format(account.getBirthday()));

		System.out.println("File Info");
		System.out.println("File name: " + file.getOriginalFilename());
		System.out.println("File type: " + file.getContentType());
		System.out.println("File size(bytes): " + file.getSize());
		String photo = upload(file);
		System.out.println("Photo: " + photo);
		account.setPhoto(photo);
		
		return "account/success";
	}

	private String upload(MultipartFile multipartFile) {
		try {
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(servletContext.getRealPath("/uploads/images/" 
									+ multipartFile.getOriginalFilename()));
			Files.write(path, bytes);
			return multipartFile.getOriginalFilename();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
