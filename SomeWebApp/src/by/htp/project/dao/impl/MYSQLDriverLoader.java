package by.htp.project.dao.impl;

import by.htp.project.dao.DBDriverLoadingException;

public class MYSQLDriverLoader {
	private static final MYSQLDriverLoader instance = new MYSQLDriverLoader();

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DBDriverLoadingException(e);
		}
	}
	
	private MYSQLDriverLoader() {}
	
	public static MYSQLDriverLoader getInstance() {
		return instance;
	}
}