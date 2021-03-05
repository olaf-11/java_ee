package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.bean.User;
import by.htp.project.controller.command.Command;
import by.htp.project.service.ServiceException;
import by.htp.project.service.ServiceProvider;
import by.htp.project.service.UserService;

public class SignIn implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String login;
		String password;
		
		login = request.getParameter("login");
		password = request.getParameter("password");
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
				
		User user = null;
		try {
			user = userService.authorization(login, password);
			
			if(user == null) {
				response.sendRedirect("Controller?command=GoToSignInPage&message=Login or password is wrong!");
				return;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			if (!user.getName().equals("")) {
				session.setAttribute("user", user.getName());
			} else {
				session.setAttribute("user", user.getLogin());
			}
			session.setAttribute("role", user.getRole());
			
			response.sendRedirect("Controller?command=GoToHomeUserPage");
			
		} catch(ServiceException e) {
			response.sendRedirect("Controller?command=GoToSignInPage&message=Something wrong with User Services");
		}

	}

}