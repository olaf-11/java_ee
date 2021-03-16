package by.htp.project.dao;

public class DBDriverLoadingException extends RuntimeException{
	private static final long serialVersionUID = 9073348016720302365L;

	public DBDriverLoadingException(Exception e) {
		super(e);
	}
}