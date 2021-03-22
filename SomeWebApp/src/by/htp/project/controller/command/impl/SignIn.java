package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.bean.User;
import by.htp.project.constant.Message;
import by.htp.project.constant.Path;
import by.htp.project.constant.Value;
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
				response.sendRedirect(Path.SIGN_IN_COMMAND + Message.LOGINATION_ERR);
				return;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute(Value.AUTH_PARAM_NAME, true);
			if (!user.getName().equals("")) {
				session.setAttribute(Value.USER_PARAM_NAME, user.getName());
			} else {
				session.setAttribute(Value.USER_PARAM_NAME, user.getLogin());
			}
			session.setAttribute("role", user.getRole());
			
			response.sendRedirect(Path.HOME_USER_SIMPLE_COMMAND);
			
		} catch(ServiceException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(Path.ERROR_URL + Message.USER_SERV_ERR);
		    dispatcher.forward(request, response);
		}

	}

}