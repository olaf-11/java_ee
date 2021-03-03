package by.htp.project.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.bean.News;
import by.htp.project.controller.command.Command;
import by.htp.project.service.NewsService;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;

public class GoToUsersHomePage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		HttpSession session = request.getSession();
		
		if (session == null) {
			response.sendRedirect("home?message=Session is out of time");
			return;
		}
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		try {
			List<News> news = newsService.takeAll();	
			request.setAttribute("news", news);
		} catch(ServiceException e) {
			response.sendRedirect("home?message=Something wrong with News Services");
		}
		
		Boolean isAuth = (Boolean)session.getAttribute("auth");
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect("home?message=Authorization error");
			return;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users_home.jsp");
		requestDispatcher.forward(request, response);

	}

}