package com.htp.bynews.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htp.bynews.entity.AppUser;

@Repository
public class UserDaoMySql implements UserDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AppUser findUserByEmail(String email) {
		
		AppUser appUser = null;
		//Session currentSession = sessionFactory.getCurrentSession();
		//System.out.println("\n email (from findUserByEmail): " + email + "\n");
		try { 
			appUser = (AppUser) sessionFactory.getCurrentSession()
					.createQuery("select u " +
								 "from AppUser u " +
								 "where u.email like :email")
					.setParameter("email", email)
					.getSingleResult();
		
			//System.out.println("status = " + status + "     (UserDao.isUserEntity())\n");
		} catch (NoResultException exc) {
			return appUser;
		}
		
		return appUser;
	}

	@Override
	public AppUser saveNewUser(AppUser user) throws DaoException {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
		//System.out.println("\nNewUserId = " + user.getId()+ "\n");
		
		return user;
	}
	
	
}
