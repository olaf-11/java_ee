package com.htp.bynews.service;

public class UserAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = -685514717097852242L;
	
	public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}