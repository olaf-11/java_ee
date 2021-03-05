package by.htp.project.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.project.controller.command.impl.GoToNewsEditPage;
import by.htp.project.controller.command.impl.GoToNewsReadPage;
import by.htp.project.controller.command.impl.GoToRegisterPage;
import by.htp.project.controller.command.impl.GoToSignInPage;
import by.htp.project.controller.command.impl.DeleteNews;
import by.htp.project.controller.command.impl.GoToHomeUserPage;
import by.htp.project.controller.command.impl.Logout;
import by.htp.project.controller.command.impl.SaveNewUser;
import by.htp.project.controller.command.impl.SaveEditedNews;
import by.htp.project.controller.command.impl.SignIn;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.GOTOREGISTERPAGE, new GoToRegisterPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GOTONEWSREADPAGE, new GoToNewsReadPage());
		commands.put(CommandName.GOTONEWSEDITPAGE, new GoToNewsEditPage());
		commands.put(CommandName.SAVEEDITEDNEWS, new SaveEditedNews());
		commands.put(CommandName.GOTOSIGNINPAGE, new GoToSignInPage());
		commands.put(CommandName.SIGNIN, new SignIn());
		commands.put(CommandName.GOTOHOMEUSERPAGE, new GoToHomeUserPage());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
	}
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}

}