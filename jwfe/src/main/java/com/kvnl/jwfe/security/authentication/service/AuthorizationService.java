package com.kvnl.jwfe.security.authentication.service;

import javax.servlet.http.HttpServletRequest;

import com.kvnl.jwfe.security.authentication.AuthenticationManagerContext;
import com.kvnl.jwfe.security.authentication.common.AuthorizationFunction;
import com.kvnl.jwfe.security.authentication.exception.AuthorizationException;
import com.kvnl.jwfe.security.authentication.exception.AuthorizationForbiddenException;
import com.kvnl.jwfe.security.authentication.exception.AuthorizationUnauthorizedException;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorization;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorizationResource;
import com.kvnl.jwfe.security.authentication.model.SecurityPrincipal;

public interface AuthorizationService<X extends SecurityPrincipal<Y>, Y extends SecurityAuthorization<Z>, Z extends SecurityAuthorizationResource> {

	boolean validateAccess(HttpServletRequest resquest) throws AuthorizationException, AuthorizationUnauthorizedException, AuthorizationForbiddenException;
	
	boolean validateAccess(HttpServletRequest resquest, AuthorizationFunction<HttpServletRequest, Boolean> authorizationFunctionF) throws AuthorizationException, AuthorizationUnauthorizedException, AuthorizationForbiddenException;
	
	Y getSessionSecurityAuthorization(HttpServletRequest request);

	void setSessionSecurityAuthorization(HttpServletRequest request, Y authorization);
	
	AuthenticationManagerContext<X,Y,Z> getAuthenticationManagerContext();
	
}
