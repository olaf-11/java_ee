package com.htp.bynews.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htp.bynews.constant.Message;
import com.htp.bynews.dao.DaoException;
import com.htp.bynews.dao.UserDao;
import com.htp.bynews.entity.AppUser;
import com.htp.bynews.entity.Role;


@Service("userServiceMySql")
public class UserServiceMySql implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public boolean registerNewUser(AppUser user) throws ServiceException {
		boolean userExist = emailExist(user.getEmail());
		
		if (userExist) {
			throw new UserAlreadyExistException("Account with \"" + 
								user.getEmail() + "\" email already exists");
		}
		
		//TODO not null fields and save
		user.setStatus("active");
		user.setPwd_comment(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<Role> listRoles = new ArrayList<>();
		listRoles.add(new Role(1, "user"));
		
		user.setRole(listRoles);
		
		try {
			userDao.saveNewUser(user);
		} catch (DaoException exc) {
			throw new ServiceException(Message.REGISTR_ERR, exc);
		}
		//System.out.println("\nPassword: " + user.getPwd_comment() + " --> " + user.getPassword() + "\n");
		
		//System.out.println("\nUser with " + user.getEmail() + " doesn't exist");
		return userExist;
	}

	private boolean emailExist(String email) {
		return userDao.findUserByEmail(email) != null;
	}

}
