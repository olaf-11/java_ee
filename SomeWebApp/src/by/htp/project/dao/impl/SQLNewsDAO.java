package by.htp.project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.project.bean.News;
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
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsmanagement?useSSL=false&serverTimezone=UTC", "root", "mX26ql1Y");
			
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM news");
			
			news = new ArrayList<News>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				
				News n = new News(id, title, brief, content);
				
				news.add(n);
				
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return news;
	}

	@Override
	public void updateNews(int newsId, String newsTitle, String newsBrief, String newsContent) throws DAOException {
		// TODO
		Connection con = null;
		Statement st = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsmanagement?useSSL=false&serverTimezone=UTC", "root", "mX26ql1Y");
			
			st = con.createStatement();
			
			final String NEWS_UPDATE = "UPDATE news SET title='" + newsTitle + "', brief='" + newsBrief + "', content='" + newsContent + "' WHERE id=" + newsId;
			//System.out.println("NEWS_UPDATE —> " + NEWS_UPDATE);
			//int col = st.executeUpdate(NEWS_UPDATE);
			st.executeUpdate(NEWS_UPDATE);
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}

}