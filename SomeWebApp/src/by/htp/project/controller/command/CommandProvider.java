package by.htp.project.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.project.controller.command.impl.GoToNewsEditor;
import by.htp.project.controller.command.impl.GoToNewsPage;
import by.htp.project.controller.command.impl.GoToRegistrationPage;
import by.htp.project.controller.command.impl.GoToSignInPage;
import by.htp.project.controller.command.impl.GoToUsersHomePage;
import by.htp.project.controller.command.impl.Logout;
import by.htp.project.controller.command.impl.SaveNewUser;
import by.htp.project.controller.command.impl.SaveEditedNews;
import by.htp.project.controller.command.impl.SignIn;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GOTONEWSPAGE, new GoToNewsPage());
		commands.put(CommandName.GOTONEWSEDITOR, new GoToNewsEditor());
		commands.put(CommandName.SAVEEDITEDNEWS, new SaveEditedNews());
		commands.put(CommandName.GOTOSIGNINPAGE, new GoToSignInPage());
		commands.put(CommandName.SIGNIN, new SignIn());
		commands.put(CommandName.GOTOUSERSHOMEPAGE, new GoToUsersHomePage());
		
	}
	
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}