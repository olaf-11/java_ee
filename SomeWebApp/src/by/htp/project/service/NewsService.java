package by.htp.project.service;

import java.util.List;

import by.htp.project.bean.News;

public interface NewsService {
	
	List<News> takeAll() throws ServiceException;
	boolean editNews(News news) throws ServiceException;
	News getNewsById(int id) throws ServiceException;
	boolean deleteNewsById(int id) throws ServiceException;
	
}