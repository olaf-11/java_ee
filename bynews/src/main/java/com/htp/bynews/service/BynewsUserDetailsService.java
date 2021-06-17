package com.htp.bynews.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htp.bynews.dao.DaoException;
import com.htp.bynews.dao.UserDao;
import com.htp.bynews.entity.AppUser;
import com.htp.bynews.entity.NewsPermission;
import com.htp.bynews.entity.Role;

@Service("userDetailsService")
public class BynewsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		AppUser appUser = null;
		
		try{
			appUser = userDao.findUserByEmail(email);
		} catch (DaoException exc) {
			throw new UsernameNotFoundException(exc.getLocalizedMessage());
		}
		//System.out.println("\n AppUser (from BynewsUserDetailsService): \n" + appUser + "\n");
		
		UserDetails details;

		if (appUser == null) {
			throw new UsernameNotFoundException(String.format("User '%s' not found", email));
		} else {
			Role userRole = appUser.getRole().get(0);
			/* 
			return User.builder()
					   .username(appUser.getEmail())
					   .password(appUser.getPassword())

					   .authorities(permissionsToAuthorities(userRole))
					   .disabled(isUserDisabled(appUser.getStatus()))
					   .credentialsExpired(false)
					   .accountExpired(false)
					   .accountLocked(false)
				       .build(); */
			details = User.builder()
			   .username(appUser.getEmail())
			   .password(appUser.getPassword())
			   //.roles(userRole.getRoleName().toUpperCase())
			   .authorities(permissionsToAuthorities(userRole))
			   .disabled(isUserDisabled(appUser.getStatus()))
			   .credentialsExpired(false)
			   .accountExpired(false)
			   .accountLocked(false)
		       .build();
		}
		/*
		System.out.println("UserRole: " + appUser.getRole().get(0).getRoleName());//userRole.getRoleName()
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("\n\nUserDetail (from BynewsUserDetailsService):");
		System.out.println("" + details.getUsername());//getUsername()
		System.out.println("" + details.getPassword());
		System.out.println("" + details.getAuthorities().toString());//  getAuthorities()
		*/
		return details; 		
	}
	
	private boolean isUserDisabled(String status) {
		if (status.toLowerCase().equals("disable")) {
			return true;
		}
		return false;
	}
	
	private Collection<? extends GrantedAuthority> permissionsToAuthorities(Role role) {
		List<SimpleGrantedAuthority> listAuthority  = role.getNewsPermission().stream()
        		   .map(r -> new SimpleGrantedAuthority("NEWS_"+ r.getPermissionName().toUpperCase()))
        		   .collect(Collectors.toList());
		listAuthority.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
        return listAuthority;
    }

}
