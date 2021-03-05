package by.htp.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.bean.News;
import by.htp.project.service.NewsService;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;

public class GoToHomeStartPage extends HttpServlet {
	private static final long serialVersionUID = 4660100370487127005L;
	
	public GoToHomeStartPage() {
		super();
	}
	
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 	ServiceProvider provider = ServiceProvider.getInstance();
		 	NewsService newsService = provider.getNewsService();
			
			try {
				List<News> news = newsService.takeAll();				
				request.setAttribute("news", news);
				
			    // Forward to /WEB-INF/views/home.jsp
			    // (Users can not access directly into JSP pages placed in WEB-INF)
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home_start_page.jsp");			      
			    dispatcher.forward(request, response);
				
			} catch (ServiceException e) {
				//
				response.sendRedirect("home_start_page?message=Something wrong with News Services");
			}

	  }
	 
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request, response);
	  }

}
