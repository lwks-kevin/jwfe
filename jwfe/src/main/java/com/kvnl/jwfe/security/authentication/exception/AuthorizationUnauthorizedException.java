package com.kvnl.jwfe.security.authentication.exception;

public class AuthorizationUnauthorizedException extends AuthorizationException {

	private static final long serialVersionUID = 1L;

	public AuthorizationUnauthorizedException() {
		super();
	}

	public AuthorizationUnauthorizedException(String message) {
		super(message);
	}

	public AuthorizationUnauthorizedException(Throwable cause) {
		super(cause);
	}

	public AuthorizationUnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
