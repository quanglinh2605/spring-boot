package com.demo.interceptors;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BasicAuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null) {
			System.out.println("Authorization  : " + authHeader);
			String usernameAndPasswordhash = authHeader.split(" ")[1];
			System.out.println("Hash: "+usernameAndPasswordhash);
			String usernameAndPassword = new String(Base64.getDecoder().decode(usernameAndPasswordhash));
			System.out.println("Username and Password: "+usernameAndPassword);
			String username = usernameAndPassword.split(":")[0];
			String password = usernameAndPassword.split(":")[1];
			System.out.println("Username: "+username);
			System.out.println("Password: "+password);
			if(username.equals("admin")&password.equals("1234")) {
				return true;
			}else {
				response.sendError(401,"Unauthorized");
				return false;
			}
		} else {
			response.sendError(401,"Unauthorized");
			return false;
		}
	}

}
