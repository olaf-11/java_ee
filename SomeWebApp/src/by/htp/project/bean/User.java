package by.htp.project.bean;

public class User {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String status;
	private String role;
	
	public User() {}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User login: " + login + "\n" +
			   "password: " + "**********" + "\n" +
			   "name: " + name + "\n" +
			   "surname: " + surname + "\n" +
			   "status: " + status + "\n" +
			   "role: " + role + "\n\n";
	}
}