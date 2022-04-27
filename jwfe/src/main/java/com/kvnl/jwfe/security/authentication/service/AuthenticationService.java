package com.kvnl.jwfe.security.authentication.service;

import javax.servlet.http.HttpServletRequest;

import com.kvnl.jwfe.security.authentication.AuthenticationManagerContext;
import com.kvnl.jwfe.security.authentication.common.AuthenticationFunction;
import com.kvnl.jwfe.security.authentication.exception.AuthenticationException;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorization;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorizationResource;
import com.kvnl.jwfe.security.authentication.model.SecurityPrincipal;

public interface AuthenticationService<X extends SecurityPrincipal<Y>, Y extends SecurityAuthorization<Z>, Z extends SecurityAuthorizationResource> {
	
	X login(HttpServletRequest request) throws AuthenticationException;
	
	X login(HttpServletRequest request, AuthenticationFunction<HttpServletRequest, X> function) throws AuthenticationException;
	
	void logout(HttpServletRequest request) throws AuthenticationException;
	
	void logout(HttpServletRequest request, AuthenticationFunction<HttpServletRequest, Void> function) throws AuthenticationException;
	
	X getSessionSecurityPrincipal(HttpServletRequest request);

	void setSessionSecurityPrincipal(HttpServletRequest request, X principal);
	
	AuthenticationManagerContext<X,Y,Z> getAuthenticationManagerContext();
	
}