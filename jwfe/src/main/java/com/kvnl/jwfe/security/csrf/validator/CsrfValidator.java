package com.kvnl.jwfe.security.csrf.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CsrfValidator {

	String generateToken();
	
	void saveToken(HttpServletRequest request, HttpServletResponse response, String key, String token);
	
	boolean validateToken(String token1, String token2);
	
	String loadToken(HttpServletRequest request, HttpServletResponse response, String key);
	
	void clearToken(HttpServletRequest request, HttpServletResponse response, String key);
	
}
