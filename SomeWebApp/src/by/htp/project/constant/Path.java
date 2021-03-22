package by.htp.project.constant;

public final class Path {
	public static final String ERROR_URL = "/WEB-INF/jsp/error_page.jsp?message=";
	public static final String HOME_START_URL = "/WEB-INF/jsp/home_start_page.jsp";
	public static final String HOME_USER_URL = "/WEB-INF/jsp/home_user_page.jsp";
	public static final String NEWS_READ_URL = "/WEB-INF/jsp/news_read_page.jsp";
	public static final String NEWS_EDIT_URL = "/WEB-INF/jsp/news_edit_page.jsp";
	public static final String REGISTER_URL = "/WEB-INF/jsp/register_page.jsp";
	public static final String SIGN_IN_URL = "/WEB-INF/jsp/sign_in_page.jsp";
	
	public static final String HOME_START_COMMAND = "Controller?command=GoToHomeStartPage&message=";
	public static final String HOME_USER_COMMAND = "Controller?command=GoToHomeUserPage&message=";
	public static final String HOME_USER_SIMPLE_COMMAND = "Controller?command=GoToHomeUserPage";
	public static final String NEWS_READ_COMMAND = "Controller?command=GoToNewsReadPage&news_id=";
	public static final String REGISTER_COMMAND = "Controller?command=GoToRegisterPage&message=";
	public static final String SIGN_IN_COMMAND = "Controller?command=GoToSignInPage&message=";
	public static final String CONTROLLER_COMMAND = "Controller?command=";
}