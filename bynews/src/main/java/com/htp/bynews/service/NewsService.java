package com.htp.bynews.service;

import java.util.List;

import com.htp.bynews.entity.News;

public interface NewsService {
	
	List<News> takeAll() throws ServiceException;
	boolean editNews(News news) throws ServiceException;
	News takeNewsById(int id) throws ServiceException;
	boolean deleteNewsById(int id) throws ServiceException;
	int addNews(News news) throws ServiceException;
	
}