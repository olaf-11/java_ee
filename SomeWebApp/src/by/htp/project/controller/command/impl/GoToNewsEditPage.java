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

public class GoToNewsEditPage implements Command {

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
		
		try {
			id = Integer.parseInt(request.getParameter(Value.NEWS_ID_PARAM_NAME));
		} catch (NumberFormatException exc) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Path.ERROR_URL + Message.NEWS_SERV_ERR);
		    dispatcher.forward(request, response);
		    return;
		}
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			News news = newsService.getNewsById(id);
			request.setAttribute("news", news);
		} catch(ServiceException e) {
			response.sendRedirect(Path.HOME_USER_COMMAND + Message.NEWS_SERV_ERR);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.NEWS_EDIT_URL);
		requestDispatcher.forward(request, response);		
	}
}