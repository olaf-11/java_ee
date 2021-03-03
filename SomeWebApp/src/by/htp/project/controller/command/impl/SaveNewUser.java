package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.bean.RegistrationInfo;
import by.htp.project.controller.command.Command;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;
import by.htp.project.service.UserService;

public class SaveNewUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		RegistrationInfo regInfo = new RegistrationInfo(login, password, name, surname);
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		try {
			userService.registration(regInfo);			
		} catch(ServiceException e) {
			//System.out.println("Something happened");
			response.sendRedirect("Controller?command=registration&message=Something wrong with User Services");
			return;
		}

		
		//regInfo - show in console
		//System.out.println("Something happened");
		
		response.sendRedirect("home?message=Registration OK");
		
		//request.setAttribute("message", "Registration OK");
		
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		//requestDispatcher.forward(request, response);
	}
}