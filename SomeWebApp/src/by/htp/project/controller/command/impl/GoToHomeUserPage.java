package by.htp.project.controller.command.impl;

import java.io.IOException;
import java.util.List;

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

public class GoToHomeUserPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		HttpSession session = request.getSession();
		
		if (session == null) {
			response.sendRedirect(Path.HOME_START_COMMAND + Message.SESSION_IS_OUT);
			return;
		}
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		try {
			List<News> news = newsService.takeAll();	
			request.setAttribute("news", news);
		} catch(ServiceException e) {
			response.sendRedirect(Path.HOME_START_COMMAND + Message.NEWS_SERV_ERR);
		}
		
		Boolean isAuth = (Boolean)session.getAttribute(Value.AUTH_PARAM_NAME);
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect(Path.HOME_START_COMMAND + Message.AUTHORIZ_ERR);
			return;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.HOME_USER_URL);
		requestDispatcher.forward(request, response);

	}

}