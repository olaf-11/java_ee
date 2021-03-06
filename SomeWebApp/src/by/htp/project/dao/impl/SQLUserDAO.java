package by.htp.project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.project.bean.User;
import by.htp.project.constant.Value;
import by.htp.project.dao.DAOException;
import by.htp.project.dao.UserDAO;

public class SQLUserDAO implements UserDAO {
	
	static {
		MYSQLDriverLoader.getInstance();
	}
	
	@Override
	public User authorization(String login, String password) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = DriverManager.getConnection(Value.DB_CONNECT_URL, Value.DB_CONNECT_LOGIN, Value.DB_CONNECT_PWD);
				
			st = con.createStatement();
			final String USER_QUARY = Value.SQL_SELECT_USER + "'" + login + "'";
			//System.out.println("USER_QUARY �> " + USER_QUARY);	
			rs = st.executeQuery(USER_QUARY);
			
			while(rs.next()) {
				if (rs.getString("password").equals(password)) {
					user = new User(rs.getString("login"), rs.getString("password"), rs.getString("name"), 
							        rs.getString("surname"), rs.getString("role"), rs.getString("status"));
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}// try

		return user;
	}

	@Override
	public boolean registration(User newUser) throws DAOException {
		//
		Connection con = null;
		Statement st = null;
		boolean isRegistered = false;
			
		try {
			con = DriverManager.getConnection(Value.DB_CONNECT_URL, Value.DB_CONNECT_LOGIN, Value.DB_CONNECT_PWD);
				
			st = con.createStatement();
			final String NEW_USER_CREATE_QUARY = Value.SQL_INSERT_USER + newUser.getLogin() + "','" 
						+ newUser.getPassword() + "','" + newUser.getName() + "','" + newUser.getSurname() + "','" 
						+ newUser.getStatus() + "','" + newUser.getRole() + "')";
			//System.out.println("NEW_USER_ADD �> " + NEW_USER_CREATE_QUARY);	
			st.executeUpdate(NEW_USER_CREATE_QUARY);
			isRegistered = true;

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}// try
	
		return isRegistered;
	}

	public boolean isUser(String login) throws DAOException {
		//
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<String> loginsList = null;
		//System.out.println();
		//System.out.println("In UserDAO isUser");
		
		try {
			con = DriverManager.getConnection(Value.DB_CONNECT_URL, Value.DB_CONNECT_LOGIN, Value.DB_CONNECT_PWD);
			
			st = con.createStatement();
			rs = st.executeQuery(Value.SQL_SELECT_ALL_LOGIN);
			
			loginsList = new ArrayList<String>();
			while(rs.next()) {
				loginsList.add(rs.getString("login"));
			}
			//System.out.println(loginsList.toString());
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		for (String s: loginsList) {
			if (s.equals(login)) {
				//System.out.println("login: \"" + login + "\" is equal -> \"" + s + "\"");
				return true;
			}
		}
		
		return false;
	}
}