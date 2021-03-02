package by.htp.project.bean;

public class User {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String status;
	private String role;
	
	public User() {
		
	}
	
	public User(String l, String p, String n, String s) {
		login = l;
		password = p;
		name = n;
		surname = s;
		role = "user";
		status = "active";
		
	}
	
	public User(String l, String p, String n, String s, String r, String st) {
		login = l;
		password = p;
		name = n;
		surname = s;
		role = r;
		status = st;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}