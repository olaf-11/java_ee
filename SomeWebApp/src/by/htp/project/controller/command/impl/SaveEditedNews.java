package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.bean.News;
import by.htp.project.constant.Message;
import by.htp.project.constant.Path;
import by.htp.project.constant.Value;
import by.htp.project.controller.command.Command;
import by.htp.project.service.NewsService;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;

public class SaveEditedNews implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id;
		
		if (session == null) {
			response.sendRedirect(Path.HOME_START_COMMAND + Message.SESSION_IS_OUT);
			return;
		}
		
		Boolean isAuth = (Boolean)session.getAttribute(Value.AUTH_PARAM_NAME);
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect(Path.HOME_START_COMMAND + Message.AUTHORIZ_ERR);
			return;
		}
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			id = Integer.parseInt(request.getParameter(Value.NEWS_ID_PARAM_NAME));
		} catch (NumberFormatException exc) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Path.ERROR_URL + Message.NEWS_SERV_ERR);
		    dispatcher.forward(request, response);
		    return;
		}

		News news = new News(id, request.getParameter("news_title"), 
							 request.getParameter("news_brief"), 
							 request.getParameter("news_content"),
							 "edited");
			
		try {
			newsService.editNews(news);		
		} catch(ServiceException e) {
			response.sendRedirect(Path.HOME_USER_COMMAND + Message.NEWS_SERV_ERR);
			return;
		}
		
		
		// Переходим на страницу с новостью
		response.sendRedirect(Path.NEWS_READ_COMMAND + id);		
	}

}