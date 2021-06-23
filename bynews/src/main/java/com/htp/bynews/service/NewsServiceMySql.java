package com.htp.bynews.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htp.bynews.dao.DaoException;
import com.htp.bynews.dao.NewsDao;
import com.htp.bynews.entity.News;

@Service
public class NewsServiceMySql implements NewsService {
	
	// need to inject customer dao
	@Autowired
	private NewsDao newsDao;

	@Transactional
	@Override
	public List<News> takeAll() throws ServiceException {
		
		List<News> news;
		try {
			news = newsDao.getAll();
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		
		Iterator<News> newsIter = news.iterator();		
		while (newsIter.hasNext()) {
			if (newsIter.next().getStatus().toLowerCase().indexOf("deleted") > -1) {
				newsIter.remove();
			}
		}

		return news;
	}

	@Transactional
	@Override
	public boolean editNews(News news) throws ServiceException {
		
		boolean isEdited = false;
		String[] apostrophe = {"\u0027", "\u0060", "\u2019", "'"};

		// There is some problems with apostrophes after edit page
		for(String ap: apostrophe) {
			news.setTitle(news.getTitle().replace(ap, "&apos;"));
			news.setBrief(news.getBrief().replace(ap, "&apos;"));
			news.setText(news.getText().replace(ap, "&apos;"));
		}

		try {
			newsDao.update(news);
			isEdited = true;
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		
		return isEdited;
	}

	@Transactional
	@Override
	public News takeNewsById(int id) throws ServiceException {
		
		News news = null;
		
		try {
			news = newsDao.getNewsById(id);
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		
		return news;
	}

	@Transactional
	@Override
	public boolean deleteNewsById(int id) throws ServiceException {

		boolean wasDeleted = false;
	
		try {
			News news = newsDao.getNewsById(id);
			news.setStatus("deleted");
			newsDao.update(news);
			wasDeleted = true;
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		return wasDeleted;
	}

	@Transactional
	@Override
	public int addNews(News news) throws ServiceException {
		int id = -1;
		
		try {
			id = newsDao.insertNews(news);
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		
		return id;
	}
	

}