package com.example.demo.configuration;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	 
	        mailSender.setUsername("nghiadeptrai001@gmail.com");
	        mailSender.setPassword(MyConstants.MY_PASSWORD);
	 
	        Properties props = mailSender.getJavaMailProperties();
	        try {
			        props.put("mail.transport.protocol", "smtp");
			        props.put("mail.smtp.auth", "true");
			        props.put("mail.smtp.starttls.enable", "true");
			        props.put("mail.debug", "true");
			        props.put("mail.smtps.ssl.enable", "true");
			        Authenticator authenticator = new Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication("nghiadeptrai001@gmail.com", "nghnha123465");
			            }
			        };
			        Session session = Session.getDefaultInstance(props, authenticator);
		     } catch(Exception ex) {
		         System.out.println("ERROR....."+ex);
		     }

	        return mailSender;
	    }

}
