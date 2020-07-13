package com.demo.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SimpleDateFormat sfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ip = request.getRemoteAddr();
		System.out.println("Access time: "+sfm.format(new Date()));
		System.out.println("IP: "+ip);
		return true;
	}

	
	
}
