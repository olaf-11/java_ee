package com.htp.bynews.service;

import com.htp.bynews.entity.User;

public interface AnyTypeUserService {
	
	User getUserInstance(String email, String password) throws ServiceException;
	boolean saveNewUserInstance(User newUser) throws ServiceException;

}