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

public class DeleteNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session == null) {
			response.sendRedirect("home_start_page?message=Session is out of time");
			return;
		}
		
		Boolean isAuth = (Boolean)session.getAttribute("auth");
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect("home_start_page?message=Authorization error");
			return;
		}
		
		// TODO
		// NumberFormatException - if the string does not contain aparsable integer.
		int id = Integer.parseInt(request.getParameter("news_id"));
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			newsService.deleteNewsById(id);
		} catch(ServiceException e) {
			response.sendRedirect("Controller?command=GoToHomeUserPage&message=Something wrong with News Services");
			return;
		}

		// Переходим на домашнюю стр с новостями
		response.sendRedirect("Controller?command=GoToHomeUserPage&message=News was deleted successfully");
	}

}