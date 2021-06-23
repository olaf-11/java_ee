package com.htp.bynews.dao;

import java.util.List;

import com.htp.bynews.entity.News;

public interface NewsDao {
	
	List<News> getAll() throws DaoException;
	void update(News news) throws DaoException;
	News getNewsById(int id) throws DaoException;
	int insertNews(News news) throws DaoException;

}