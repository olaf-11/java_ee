package by.htp.project.service.impl;

import java.util.Iterator;
import java.util.List;

import by.htp.project.bean.News;
import by.htp.project.dao.DAOException;
import by.htp.project.dao.DAOProvider;
import by.htp.project.dao.NewsDAO;
import by.htp.project.service.NewsService;
import by.htp.project.service.ServiceException;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> takeAll() throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		List<News> news;
		try {
			news = newsDAO.all();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		Iterator<News> newsIter = news.iterator();		
		while (newsIter.hasNext()) {
			if (newsIter.next().getStatus().toLowerCase().indexOf("deleted") > -1) {
				newsIter.remove();
			}
		}

		return news;
	}

	@Override
	public boolean editNews(News news) throws ServiceException {
		
		boolean isEdited = false;
		String[] apostrophe = {"\u0027", "\u0060", "\u2019", "'"};

		// Какая-то проблема с апострофами после окна редактирования
		for(String ap: apostrophe) {
			news.setTitle(news.getTitle().replace(ap, "&apos;"));
			news.setBrief(news.getBrief().replace(ap, "&apos;"));
			news.setContent(news.getContent().replace(ap, "&apos;"));
		}

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
	
		try {
			newsDAO.update(news);
			isEdited = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
			//System.out.println("Error");
		}
		
		return isEdited;
	}

	@Override
	public News getNewsById(int id) throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		News news = null;
		
		try {
			news = newsDAO.getNewsById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return news;
	}

	@Override
	public boolean deleteNewsById(int id) throws ServiceException {

		boolean wasDeleted = false;
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
	
		try {
			News news = newsDAO.getNewsById(id);
			news.setStatus("deleted");
			newsDAO.update(news);
			wasDeleted = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
			//System.out.println("Error");
		}
		return wasDeleted;
	}

}