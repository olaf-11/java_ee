package com.htp.bynews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htp.bynews.constant.Message;
import com.htp.bynews.dao.DaoException;
import com.htp.bynews.dao.UserDao;
import com.htp.bynews.entity.User;

@Service
public class UserMySqlService implements AnyTypeUserService {
	
	// need to inject user DAO
	@Autowired
	UserDao userDao;

	@Transactional
	public User getUserInstance(String email, String password) throws ServiceException {
		// TODO Validation services
		System.out.println("email: " + email + "     password: " + password + "   (AnyTypeUserService.getUserInstance())\n");
		if(email == null || "".equals(email) || password == null || "".equals(password)) {
			throw new ServiceException(Message.LOGINATION_ERR);
		}
		
		User user = null;
		
		try {
			System.out.println("try-catch AnyTypeUserService.getUserInstance()");
			
			// TODO DELETE isUE — it's only for check!!! 
			boolean isUE = userDao.isUserEntity(email);
			System.out.println("userDao.isUserEntity(email) = " + isUE);
			
			if(isUE) {
				user = userDao.extractUserEntity(email);
				//c
			}
		}catch(DaoException e) {
			throw new ServiceException(Message.USER_NOT_EXIST_ERR, e);
		}
		
		return user;
	}

	@Transactional
	public boolean saveNewUserInstance(User newUser) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
