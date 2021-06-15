package com.htp.bynews.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class BynewsSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "/home", "/login", "/index", "/registration", "/resources/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login2").permitAll()
			.defaultSuccessUrl("/home_user_page", true);// TODO start_user_page ?
	}
	
}
