package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.controller.command.Command;
import by.htp.project.service.NewsService;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;

public class SaveEditedNews implements Command{

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
		
		String newsHeader = request.getParameter("news_header");
		String newsBrief = request.getParameter("news_brief");
		String newsTexts = request.getParameter("news_texts");
		int newsId = Integer.parseInt(request.getParameter("id"));

		//System.out.println(" === news_header === " + newsHeader);
		//TO DO сохранить в базу данных изменения
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			newsService.editNews(newsId, newsHeader, newsBrief, newsTexts);			
		} catch(ServiceException e) {
			// DON"T KNOW WHERE
			response.sendRedirect("Controller?command=GoToUsersHomePage&message=Something wrong with News Services");
			return;
		}
		
		
		// Переходим на страницу с новостью
		response.sendRedirect("Controller?command=GoToNewsPage&id=" + newsId);
		
	}

}