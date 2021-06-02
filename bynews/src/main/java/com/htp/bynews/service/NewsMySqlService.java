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
public class NewsMySqlService implements NewsService {
	
	// need to inject customer dao
	@Autowired
	private NewsDao newsDao;

	@Transactional
	public List<News> takeAll() throws ServiceException {
		
		List<News> news;
		try {
			news = newsDao.all();
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		
		/*Iterator<News> newsIter = news.iterator();		
		while (newsIter.hasNext()) {
			if (newsIter.next().getStatus().toLowerCase().indexOf("deleted") > -1) {
				newsIter.remove();
			}
		}*/

		return news;
	}

	@Transactional
	public boolean editNews(News news) throws ServiceException {
		
		boolean isEdited = false;
		String[] apostrophe = {"\u0027", "\u0060", "\u2019", "'"};

		// Какая-то проблема с апострофами после окна редактирования
		for(String ap: apostrophe) {
			news.setTitle(news.getTitle().replace(ap, "&apos;"));
			news.setBrief(news.getBrief().replace(ap, "&apos;"));
			news.setContent(news.getContent().replace(ap, "&apos;"));
		}

		try {
			newsDao.update(news);
			isEdited = true;
		} catch (DaoException exception) {
			throw new ServiceException(exception);
			//System.out.println("Error");
		}
		
		return isEdited;
	}

	@Transactional
	public News getNewsById(int id) throws ServiceException {
		
		News news = null;
		
		try {
			news = newsDao.getNewsById(id);
		} catch (DaoException exception) {
			throw new ServiceException(exception);
		}
		
		return news;
	}

	@Transactional
	public boolean deleteNewsById(int id) throws ServiceException {

		boolean wasDeleted = false;
	
		try {
			News news = newsDao.getNewsById(id);
			news.setStatus("deleted");
			newsDao.update(news);
			wasDeleted = true;
		} catch (DaoException exception) {
			throw new ServiceException(exception);
			//System.out.println("Error");
		}
		return wasDeleted;
	}

}