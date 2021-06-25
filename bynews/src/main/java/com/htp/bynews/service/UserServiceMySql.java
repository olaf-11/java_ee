package com.htp.bynews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htp.bynews.dao.DaoException;
import com.htp.bynews.dao.UserDao;
import com.htp.bynews.entity.AppUser;

@Service("userServiceMySql")
public class UserServiceMySql implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public boolean registerNewUser(AppUser user) throws ServiceException {
		boolean userExist = emailExist(user.getEmail());
		
		if (userExist) {
			throw new UserAlreadyExistException("Account with \"" + 
								user.getEmail() + "\" email already exists");
		}
		
		//TODO not null fields and save
		
		//System.out.println("\nUser with " + user.getEmail() + " doesn't exist");
		return userExist;
	}

	private boolean emailExist(String email) {
		return userDao.findUserByEmail(email) != null;
	}

}
