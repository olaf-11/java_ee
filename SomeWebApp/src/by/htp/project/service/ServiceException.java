package by.htp.project.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = -728591227449721916L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
