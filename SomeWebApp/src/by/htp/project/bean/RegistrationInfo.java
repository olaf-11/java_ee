package by.htp.project.bean;

public class RegistrationInfo {
	private String login;
	private String password;
	private String name;
	private String surname;
	
	
	public RegistrationInfo() {
		
	}
	
	public RegistrationInfo(String l, String p, String n, String s) {
		login = l;
		password = p;
		name = n;
		surname = s;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}