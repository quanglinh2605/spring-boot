package com.demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.demo.interceptors.BasicAuthInterceptor;
import com.demo.interceptors.LogInterceptor;
import com.demo.interceptors.LogInterceptor2;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor());
		registry.addInterceptor(new LogInterceptor2());
		registry.addInterceptor(new BasicAuthInterceptor());
	}
	
}
