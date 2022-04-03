package com.kvnl.jwfe.security.csrf.annotation;

public enum RequestMethod {
	GET("GET"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE");
	
	private final String value;
	
	private RequestMethod(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
