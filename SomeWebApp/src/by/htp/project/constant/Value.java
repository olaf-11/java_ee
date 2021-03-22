package by.htp.project.constant;

public final class Value {
	public static final String AUTH_PARAM_NAME = "auth";
	public static final String NEWS_ID_MESSAGE_PART = "&news_id=";	
	public static final String NEWS_ID_PARAM_NAME = "news_id";
	public static final String USER_PARAM_NAME = "user";
	
	//public static final String NEWS_LIST_PARAM_NAME = "news";
	//public static final String NEWS_TITLE_PARAM_NAME = "news_title";
	//public static final String NEWS_BRIEF_PARAM_NAME = "news_brief";
	//public static final String NEWS_CONTENT_PARAM_NAME = "news_content";
	//public static final String NEWS_STATUS_EDITED = "edited";
	
	/*
	public static final String NEWS_ID_DB_KEY = "id";
	public static final String NEWS_TITLE_DB_KEY = "title";
	public static final String NEWS_BRIEF_DB_KEY = "brief";
	public static final String NEWS_CONTENT_DB_KEY = "content";
	public static final String NEWS_STATUS_DB_KEY = "status";
	public static final String NEWS_STATUS_DEL = "deleted";

	public static final String USER_LOGIN_DB_KEY = "login";
	public static final String USER_PWD_DB_KEY = "password";
	public static final String USER_NAME_DB_KEY = "name";
	public static final String USER_SURNAME_DB_KEY = "surname";
	public static final String USER_ROLE_DB_KEY = "role";
	public static final String USER_STATUS_DB_KEY = "status";
	*/

	public static final String LOCAL_LANG = "lang";
	public static final String LAST_COMMAND_PARAM = "lastCommand";

	public static final String DB_CONNECT_URL = "jdbc:mysql://127.0.0.1/newsmanagement?useSSL=false&serverTimezone=UTC";
	public static final String DB_CONNECT_LOGIN = "root";
	public static final String DB_CONNECT_PWD = "mX26ql1Y";

	public static final String SQL_SELECT_USER = "SELECT * FROM users WHERE login=";
	public static final String SQL_INSERT_USER = "INSERT INTO users(login, password, name, surname, status, role) VALUES('";
	public static final String SQL_SELECT_ALL_LOGIN = "SELECT login FROM users";
	public static final String SQL_SELECT_ALL_NEWS = "SELECT * FROM news";
	public static final String SQL_SELECT_NEWS_BY_ID = "SELECT * FROM news WHERE id=";
}