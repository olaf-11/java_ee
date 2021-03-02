package by.htp.project.service.impl;

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
		
		return news;
	}

	@Override
	public void editNews(int newsId, String newsTitle, String newsBrief, String newsContent) throws ServiceException {
		//
		String[] apostrophe = {"\u0027", "\u0060", "\u2019", "'"};
		for(String ap: apostrophe) {
			newsTitle = newsTitle.replace(ap, "&apos;");
			newsBrief = newsBrief.replace(ap, "&apos;");
			newsContent = newsContent.replace(ap, "&apos;");
		}
		
		//System.out.println("newsTitle —> " + newsTitle);
		//System.out.println("newsBrief —> " + newsBrief);
		//System.out.println("newsContent —> " + newsContent);
		
		
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
	
		try {
			newsDAO.updateNews(newsId, newsTitle, newsBrief, newsContent);
		} catch (DAOException e) {
			throw new ServiceException(e);
			//System.out.println("Error");
		}
	}

}
