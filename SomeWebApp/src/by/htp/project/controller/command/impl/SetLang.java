package by.htp.project.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.constant.Path;
import by.htp.project.constant.Value;
import by.htp.project.controller.command.Command;

public class SetLang implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String params = "";
		String lang = request.getParameter(Value.LOCAL_LANG);
		String lastCommand = request.getParameter(Value.LAST_COMMAND_PARAM);
		//System.out.println();
		String news_id = request.getParameter(Value.NEWS_ID_PARAM_NAME);
		
		if(news_id != null && !("".equals(news_id))) {
			params = Value.NEWS_ID_MESSAGE_PART + news_id;
		}

		HttpSession session = request.getSession(false);
		session.setAttribute(Value.LOCAL_LANG, lang);

		response.sendRedirect(Path.CONTROLLER_COMMAND + lastCommand + params);
		
	}

}
