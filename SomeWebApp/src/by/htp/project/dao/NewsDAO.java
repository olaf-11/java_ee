package by.htp.project.dao;

import java.util.List;

import by.htp.project.bean.News;

public interface NewsDAO {
	
	List<News> all()  throws DAOException;
	void updateNews(int newsId, String newsTitle, String newsBrief, String newsContent) throws DAOException;

}