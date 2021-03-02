package by.htp.project.dao;

import by.htp.project.bean.User;

public interface UserDAO {
	
	User authorization (String login, String password) throws DAOException;
	boolean	registration(User user) throws DAOException;
	boolean isUser(String login) throws DAOException;

}
