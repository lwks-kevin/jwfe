package com.kvnl.jwfe.security.authentication.repository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kvnl.jwfe.security.authentication.AuthenticationManagerContext;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorization;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorizationResource;
import com.kvnl.jwfe.security.authentication.model.SecurityPrincipal;

public interface AuthenticationRepository<X extends SecurityPrincipal<Y>, Y extends SecurityAuthorization<Z>, Z extends SecurityAuthorizationResource> {
	
	X getSecurityPrincipal(String identity, String certification);
	
	Y getSecurityAuthorizationById(String authorizationId);
	
	List<Z> getSecurityAuthorizationResourceListByAuthorizationId(String authorizationId);
	
	
	X getSessionSecurityPrincipal(HttpServletRequest request);

	void setSessionSecurityPrincipal(HttpServletRequest request, X principal);
	
	Y getSessionSecurityAuthorization(HttpServletRequest request);

	void setSessionSecurityAuthorization(HttpServletRequest request, Y authorization);

	
	AuthenticationManagerContext<X,Y,Z> getAuthenticationManagerContext();
	
}
