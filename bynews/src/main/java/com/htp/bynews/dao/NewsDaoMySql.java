package com.htp.bynews.dao;

import java.util.List;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htp.bynews.entity.News;

@Repository
public class NewsDaoMySql implements NewsDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getAll() throws DaoException {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<News> news = null;
		
		try {
			
			// create a query
			Query<News> theQuery = currentSession.createQuery("from News", News.class);
					
			// execute query and get result list
			news = theQuery.getResultList();
			
		} catch (QueryException e) {
			throw new DaoException(e);
		}
		
		// return the results
		return news;
	}

	@Override
	public void update(News news) throws DaoException {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// set current date & time
		news.setDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		try {
			
			// save/update the news
			currentSession.saveOrUpdate(news);
			
		} catch (QueryException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public News getNewsById(int id) throws DaoException {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		News news = null;
		
		try {
			
			// now retrieve/read from database using the primary key
			news = currentSession.get(News.class, id);
			
		} catch (QueryException e) {
			throw new DaoException(e);
		}
		
		return news;
	}

	@Override
	public int insertNews(News news) throws DaoException {
		
		int id = -1;
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// set current date & time
		news.setDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		news.setStatus("active");
		
		//System.out.println("\n... from Nes DAO...");
		//System.out.println("NEWS\n" + news);
		
		try {
				
			// save/update the news
			currentSession.saveOrUpdate(news);
			
		} catch (QueryException e) {
			throw new DaoException(e);
		}
		//System.out.println("\nID of added News = " + news.getId() + "\n");
		//System.out.println("id = " + id);
		id = news.getId();
		return id;
	}

}