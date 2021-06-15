package com.htp.bynews.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htp.bynews.entity.User;

@Repository
public class UserMySqlDao implements UserDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isUserEntity(String email) throws DaoException {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String status = null;
		
		try { 
			status = (String) currentSession.createQuery(
						"select u.status " +
						"from User u " +
						"where u.email like :email")
					.setParameter("email", email)
					.getSingleResult();
		
			System.out.println("status = " + status + "     (UserDao.isUserEntity())\n");
		} catch (NoResultException exc) {
			return false;
		}
		
		if(status != null && !"".equals(status) && status.toLowerCase().equals("active")) {
			return true;
		}
		
		return false;		
	}

	@Override
	public User extractUserEntity(String email) throws DaoException {
		// TODO extract User from 'users' table
		return new User();
	}

	@Override
	public boolean insertNewUserEntity(User newUser) throws DaoException {
		// TODO save User in 'users' table
		return false;
	}

}
