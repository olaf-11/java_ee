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

public class GoToNewsEditor implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if (session == null) {
			response.sendRedirect("home?message=session is out of time");
			return;
		}
		
		Boolean isAuth = (Boolean)session.getAttribute("auth");
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect("home?message=Authorization error");
			return;
		}
		
		int newsId = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println(" === newsId === " + newsId);
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			List<News> news = newsService.takeAll();
			
			for(News nw: news) {
				if (nw.getId() == newsId) {
					request.setAttribute("news", nw);
				}
			}
			
		} catch(ServiceException e) {
			// DON'T KNOW WHERE
			response.sendRedirect("home?message=Something wrong with News Services");
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_news_page.jsp");
		requestDispatcher.forward(request, response);
		
	}
}