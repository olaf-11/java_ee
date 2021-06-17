package com.htp.bynews.dao;

import com.htp.bynews.entity.AppUser;

public interface UserDao {
	AppUser findUserByEmail(String email);
}