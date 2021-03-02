package by.htp.project.service;

import java.util.List;

import by.htp.project.bean.News;

public interface NewsService {
	List<News> takeAll() throws ServiceException;
	void editNews(int newsId, String newsTitle, String newsBrief, String newsContent) throws ServiceException;
}