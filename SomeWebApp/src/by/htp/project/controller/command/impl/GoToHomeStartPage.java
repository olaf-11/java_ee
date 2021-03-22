package by.htp.project.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.bean.News;
import by.htp.project.constant.Message;
import by.htp.project.constant.Path;
import by.htp.project.controller.command.Command;
import by.htp.project.service.NewsService;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;

public class GoToHomeStartPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			List<News> news = newsService.takeAll();				
			request.setAttribute("news", news);
			
		    // Forward to /WEB-INF/views/home.jsp
		    // (Users can not access directly into JSP pages placed in WEB-INF)
			RequestDispatcher dispatcher = request.getRequestDispatcher(Path.HOME_START_URL);			      
		    dispatcher.forward(request, response);
				
	 	} catch (ServiceException e) {
	 		RequestDispatcher dispatcher = request.getRequestDispatcher(Path.ERROR_URL + Message.NEWS_SERV_ERR);
		    dispatcher.forward(request, response);
	 	}

 	}

}