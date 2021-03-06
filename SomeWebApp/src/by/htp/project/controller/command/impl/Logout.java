package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.constant.Message;
import by.htp.project.constant.Path;
import by.htp.project.controller.command.Command;

public class Logout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session != null) {
			session.removeAttribute("auth");
		}
		
		response.sendRedirect(Path.HOME_START_COMMAND + Message.LOGOUT_OK);		
	}

}