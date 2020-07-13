package com.example.demo.configuration;

import com.ckfinder.connector.ConnectorServlet;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CKFinderServletConfig {

    @Value("${ckeditor.storage.image.path}")
    private String baseDir;
    @Value("${ckeditor.access.image.url}")
    private String baseURL;

    @Bean
    public ServletRegistrationBean<Servlet> connectCKFinder(){
        ServletRegistrationBean<Servlet> registrationBean= new ServletRegistrationBean<Servlet>(new ConnectorServlet(),"/resources/ckfinder/core/connector/java/connector.java");
        registrationBean.addInitParameter("XMLConfig","classpath:/static/ckfinder.xml");
        registrationBean.addInitParameter("debug","false");
        registrationBean.addInitParameter("configuration","com.example.demo.configuration.CKFinderConfig");
        //ckfinder.xml 
        registrationBean.addInitParameter("baseDir",baseDir);
        registrationBean.addInitParameter("baseURL",baseURL); 
        return registrationBean;
    }    
}
