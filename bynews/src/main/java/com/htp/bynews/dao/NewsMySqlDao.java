package com.htp.bynews.dao;

import java.util.Arrays;
import java.util.List;

//import org.hibernate.QueryException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htp.bynews.entity.News;

@Repository
public class NewsMySqlDao implements NewsDao {
	
	// need to inject the session factory
	//@Autowired
	//private SessionFactory sessionFactory;

	@Override
	public List<News> all() throws DaoException {

		// get the current hibernate session
		/*Session currentSession = sessionFactory.getCurrentSession();
		
		List<News> news = null;
		
		try {
			
			// create a query
			Query<News> theQuery = currentSession.createQuery("from News", News.class);
					
			// execute query and get result list
			news = theQuery.getResultList();
			
		} catch (QueryException e) {
			throw new DaoException(e);
		} */
		
		List<News> news = Arrays.asList(new News("header for news 4", "breaf for news 4 from DAO-layer", "some content for news 4 from DAO-layer"), 
										new News("header for news 5", "breaf for news 5 from DAO-layer", "some content for news 5 from DAO-layer"), 
										new News("header for news 6", "breaf for news 6 from DAO-layer", "some content for news 6 from DAO-layer"));
		// return the results
		return news;
	}

	@Override
	public void update(News news) throws DaoException {
		
		// get current hibernate session
		/*Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			
			// save/upate the customer
			currentSession.saveOrUpdate(news);
			
		} catch (QueryException e) {
			throw new DaoException(e);
		} */
	}

	@Override
	public News getNewsById(int id) throws DaoException {
		
		// get current hibernate session
		/*Session currentSession = sessionFactory.getCurrentSession();
		
		News news = null;
		
		try {
			
			// now retrieve/read from database using the primary key
			news = currentSession.get(News.class, id);
			
		} catch (QueryException e) {
			throw new DaoException(e);
		} */
		
			News news = new News("header for news by id", "breaf for news by id", "some content for news by id");
		return news;
	}

}
