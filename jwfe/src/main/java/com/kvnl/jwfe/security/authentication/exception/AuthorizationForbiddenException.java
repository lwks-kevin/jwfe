package com.kvnl.jwfe.security.authentication.exception;

public class AuthorizationForbiddenException extends AuthorizationException {

	private static final long serialVersionUID = 1L;

	public AuthorizationForbiddenException() {
		super();
	}

	public AuthorizationForbiddenException(String message) {
		super(message);
	}

	public AuthorizationForbiddenException(Throwable cause) {
		super(cause);
	}

	public AuthorizationForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
