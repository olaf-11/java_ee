package com.htp.bynews.service;

import com.htp.bynews.entity.AppUser;

public interface UserService {
	
	boolean registerNewUser(AppUser user) throws ServiceException;
	
}