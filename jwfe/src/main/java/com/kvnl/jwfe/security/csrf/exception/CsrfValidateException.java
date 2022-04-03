package com.kvnl.jwfe.security.csrf.exception;

public class CsrfValidateException extends Exception {

	private static final long serialVersionUID = 1L;

	public CsrfValidateException() {
		super();
	}

	public CsrfValidateException(String message) {
		super(message);
	}

	public CsrfValidateException(Throwable cause) {
		super(cause);
	}
	
}
