package by.htp.project.dao;

import by.htp.project.dao.impl.SQLNewsDAO;
import by.htp.project.dao.impl.SQLUserDAO;

public final class DAOProvider {
	
	private static final DAOProvider instance = new DAOProvider();	
	
	private final UserDAO userdao = new SQLUserDAO();
	private final NewsDAO newsDAO = new SQLNewsDAO();
	
	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}	

}
