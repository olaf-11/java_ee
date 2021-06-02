package com.htp.bynews.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.htp.bynews.entity.News;

@Service
public class NewsSimpleService implements NewsService {

	@Override
	public List<News> takeAll() throws ServiceException {
		List<News> news = Arrays.asList(new News("header for news 1", "breaf for news 1", "some content for news 1"), 
										new News("header for news 2", "breaf for news 2", "some content for news 2"), 
										new News("header for news 3", "breaf for news 3", "some content for news 3"));
		return news;
	}

	@Override
	public boolean editNews(News news) throws ServiceException {
		return false;
	}

	@Override
	public News getNewsById(int id) throws ServiceException {
		return null;
	}

	@Override
	public boolean deleteNewsById(int id) throws ServiceException {
		return false;
	}

}
