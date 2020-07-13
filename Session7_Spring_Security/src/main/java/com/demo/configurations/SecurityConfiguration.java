package com.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.services.UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/superadmin/report/**").access("hasRole('ROLE_SUPER_ADMIN')")
			.antMatchers("/admin/invoice/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
			.antMatchers("/employee/product/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
			.antMatchers("/dashboard/report").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
			.and()
			.formLogin().loginPage("/dashboard/index")
			.loginProcessingUrl("/dashboard/process-login")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/dashboard/welcome")
			.failureUrl("/dashboard/index?error")
			.and()
			.logout()
			.logoutUrl("/dashboard/logout")
			.logoutSuccessUrl("/dashboard/index?success")
			.and()
			.exceptionHandling().accessDeniedPage("/dashboard/accessdenied")
			;
		
	}

}
