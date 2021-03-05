package by.htp.project.dao;

import java.util.List;

import by.htp.project.bean.News;

public interface NewsDAO {
	
	List<News> all()  throws DAOException;
	void update(News news) throws DAOException;
	News getNewsById(int id) throws DAOException;
	
}