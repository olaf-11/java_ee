package com.htp.bynews.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class BynewsSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers( "/login", "/index", "/logout", 
						     "/signup", "/resources/**").permitAll()
				.antMatchers("/", "/start").anonymous()
				.antMatchers("/news/add").hasAuthority("NEWS_ADD")
				.antMatchers("/news/read/**").hasAuthority("NEWS_READ")
				.antMatchers("/news/edit/**").hasAuthority("NEWS_EDIT")
				.antMatchers("/news/delete/**").hasAuthority("NEWS_DELETE")
				.anyRequest().authenticated()
			.and().formLogin()
				.loginPage("/login")
				.passwordParameter("pswd")
				.usernameParameter("email")
				.defaultSuccessUrl("/home", true)
				.failureUrl("/login?error").permitAll()
			.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/start")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}