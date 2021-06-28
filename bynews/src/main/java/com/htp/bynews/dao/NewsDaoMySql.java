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
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getAll() throws DaoException {

		Session currentSession = sessionFactory.getCurrentSession();
		List<News> news = null;
		
		try {
			Query<News> theQuery = currentSession.createQuery("from News", News.class);
			news = theQuery.getResultList();
		} catch (QueryException e) {
			throw new DaoException(e);
		}
		return news;
	}

	@Override
	public void update(News news) throws DaoException {
		
		Session currentSession = sessionFactory.getCurrentSession();
		news.setDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		try {
			currentSession.saveOrUpdate(news);
		} catch (QueryException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public News getNewsById(int id) throws DaoException {
		
		Session currentSession = sessionFactory.getCurrentSession();
		News news = null;
		
		try {
			news = currentSession.get(News.class, id);
		} catch (QueryException e) {
			throw new DaoException(e);
		}
		return news;
	}

	@Override
	public int insertNews(News news) throws DaoException {
		
		int id = -1;
		Session currentSession = sessionFactory.getCurrentSession();
		news.setDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		news.setStatus("active");
 
		try {
			currentSession.saveOrUpdate(news);
		} catch (QueryException e) {
			throw new DaoException(e);
		}
		id = news.getId();
		return id;
	}

}