package by.htp.project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.project.bean.News;
import by.htp.project.constant.Value;
import by.htp.project.dao.DAOException;
import by.htp.project.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public List<News> all() throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		List<News> news = null;
		try {
			con = DriverManager.getConnection(Value.DB_CONNECT_URL, Value.DB_CONNECT_LOGIN, Value.DB_CONNECT_PWD);
			
			st = con.createStatement();
			rs = st.executeQuery(Value.SQL_SELECT_ALL_NEWS);
			
			news = new ArrayList<News>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				String status = rs.getString("status");
				
				News n = new News(id, title, brief, content, status);
				
				news.add(n);
				
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
		}

		return news;
	}

	@Override
	public void update(News news) throws DAOException {
		
		Connection con = null;
		Statement st = null;
		final String NEWS_UPDATE = "UPDATE news SET title='" + news.getTitle() + 
								   "', brief='" + news.getBrief() + 
								   "', content='" + news.getContent() +
								   "', status='" + news.getStatus() +
								   "' WHERE id=" + news.getId();
		
		try {
			con = DriverManager.getConnection(Value.DB_CONNECT_URL, Value.DB_CONNECT_LOGIN, Value.DB_CONNECT_PWD);
			
			st = con.createStatement();
			//System.out.println("NEWS_UPDATE —> " + NEWS_UPDATE);
			st.executeUpdate(NEWS_UPDATE);
			
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
	}

	@Override
	public News getNewsById(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		News news = null;

		try {
			con = DriverManager.getConnection(Value.DB_CONNECT_URL, Value.DB_CONNECT_LOGIN, Value.DB_CONNECT_PWD);
			
			st = con.createStatement();
			rs = st.executeQuery(Value.SQL_SELECT_NEWS_BY_ID + id);
			
			while(rs.next()) {
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				String status = rs.getString("status");
				
				news = new News(id, title, brief, content, status);
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
		}

		return news;
	}

}