package com.htp.bynews.dao;

import com.htp.bynews.entity.User;

public interface UserDao {
	
	boolean isUserEntity(String email) throws DaoException;
	User extractUserEntity(String email) throws DaoException;
	boolean insertNewUserEntity(User newUser) throws DaoException;

}