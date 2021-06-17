package com.htp.bynews.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htp.bynews.entity.AppUser;

@Repository
public class UserDaoMySql implements UserDao{
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AppUser findUserByEmail(String email) {
		
		//Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("\n email (from findUserByEmail): " + email + "\n");
		//try { 
			AppUser appUser = (AppUser) sessionFactory.getCurrentSession()
					.createQuery("select u " +
								 "from AppUser u " +
								 "where u.email like :email")
					.setParameter("email", email)
					.getSingleResult();
		
			//System.out.println("status = " + status + "     (UserDao.isUserEntity())\n");
		//} catch (NoResultException exc) {
		//	return false;
		//}
		
		return appUser;
		
	}

}
