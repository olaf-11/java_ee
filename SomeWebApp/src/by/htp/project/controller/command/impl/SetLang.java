package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.controller.command.Command;

public class SetLang implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String params = "";
		String lang = request.getParameter("lang");
		String lastCommand = request.getParameter("lastCommand");
		//System.out.println();
		String news_id = request.getParameter("news_id");
		
		if(news_id != null && !("".equals(news_id))) {
			params = "&news_id=" + news_id;
		}

		HttpSession session = request.getSession(false);
		session.setAttribute("lang", lang);

		response.sendRedirect("Controller?command=" + lastCommand + params);
		
	}

}
