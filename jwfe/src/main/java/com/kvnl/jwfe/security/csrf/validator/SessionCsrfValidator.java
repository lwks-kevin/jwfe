package com.kvnl.jwfe.security.csrf.validator;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kvnl.jwfe.security.csrf.base.CsrfConstant;
import com.kvnl.jwfe.security.csrf.base.CsrfTokenStorageMap;

public class SessionCsrfValidator implements CsrfValidator {

	private String csrfTokenStorageSessionKey;
	
	public SessionCsrfValidator() {
		csrfTokenStorageSessionKey = CsrfConstant.CSRF_TOKEN_STORAGE;
	}
	
	public SessionCsrfValidator(String tokenStorageSessionKey) {
		csrfTokenStorageSessionKey = tokenStorageSessionKey;
	}
	
	@Override
	public String generateToken() {
		return UUID.randomUUID().toString();
	}
	
	@Override
	public void saveToken(HttpServletRequest request, HttpServletResponse response, String key, String token) {
		HttpSession session = request.getSession(true);
		CsrfTokenStorageMap csrfTokenStorageMap = (CsrfTokenStorageMap) session.getAttribute(csrfTokenStorageSessionKey);
		if (csrfTokenStorageMap == null) {
			csrfTokenStorageMap = new CsrfTokenStorageMap();
		}
		csrfTokenStorageMap.put(key, token);
		session.setAttribute(csrfTokenStorageSessionKey, csrfTokenStorageMap);
	}

	@Override
	public boolean validateToken(String token1, String token2) {
		if (token1 != null || token2 != null) {
			return equalsToken(token1, token2);
		}
		return false;
	}

	@Override
	public String loadToken(HttpServletRequest request, HttpServletResponse response, String key) {
		HttpSession session = request.getSession(true);
		CsrfTokenStorageMap csrfTokenStorageMap = (CsrfTokenStorageMap) session.getAttribute(csrfTokenStorageSessionKey);
		if (csrfTokenStorageMap != null) {
			String token = csrfTokenStorageMap.get(key);
			return token;
		}
		return null;
	}
	
	@Override
	public void clearToken(HttpServletRequest request, HttpServletResponse response, String key) {
		HttpSession session = request.getSession(true);
		CsrfTokenStorageMap csrfTokenStorageMap = (CsrfTokenStorageMap) session.getAttribute(csrfTokenStorageSessionKey);
		if (csrfTokenStorageMap != null) {
			csrfTokenStorageMap.remove(key);
		}
	}
	
	private boolean equalsToken(String token1, String token2) {
		return token1.equals(token2);
	}

}
