package com.htp.bynews.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htp.bynews.entity.AppUser;

@Repository
public class UserDaoMySql implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AppUser findUserByEmail(String email) {
		
		AppUser appUser = null;

		try { 
			appUser = (AppUser) sessionFactory.getCurrentSession()
					.createQuery("select u " +
								 "from AppUser u " +
								 "where u.email like :email")
					.setParameter("email", email)
					.getSingleResult();

		} catch (NoResultException exc) {
			return appUser;
		}
		
		return appUser;
	}

	@Override
	public AppUser saveNewUser(AppUser user) throws DaoException {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
		return user;
	}

}