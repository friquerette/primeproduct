package com.friquerette.primems.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()//
				.dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from customer where username=?")
				.authoritiesByUsernameQuery("select username, role from customer where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()//
				.antMatchers("/", "/home").permitAll() //
				.antMatchers("/home/admin/**").access("hasRole('ADMIN')")//
				.antMatchers("/home/account/**").access("hasRole('USER') or hasRole('ADMIN') ")//
				.and().formLogin()// .loginPage("/login")//
				.and().exceptionHandling().accessDeniedPage("/accessdenied");

		/**
		 * HttpBasic Authentication is used to simple but this method is not
		 * very secure. Do better with more time (OAuth2 ...)
		 * 
		 * The category and the customer are
		 */
		http.authorizeRequests()//
				.antMatchers("/rest/category/**").access("hasRole('USER') or hasRole('ADMIN')")//
				.antMatchers("/rest/customer/**").access("hasRole('ADMIN') ")//
				.and().httpBasic();

	}
}
