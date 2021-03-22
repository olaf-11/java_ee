package by.htp.project.bean;

public class RegistrationInfo {
	private String login;
	private String password;
	private String name;
	private String surname;
	
	
	public RegistrationInfo() {
		
	}
	
	public RegistrationInfo(String l, String p, String n, String s) {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		RegistrationInfo other = (RegistrationInfo) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistrationInfo login: " + login + "\n" + 
			   "password: " + "***********" + "\n" +
			   "name: " + name + "\n" +
			   "surname: " + surname + "\n\n";
	}	
}