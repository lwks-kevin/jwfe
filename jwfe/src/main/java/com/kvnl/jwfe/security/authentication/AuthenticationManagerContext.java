package com.kvnl.jwfe.security.authentication;

import com.kvnl.jwfe.security.authentication.configuration.AuthenticationConfiguration;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorization;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorizationResource;
import com.kvnl.jwfe.security.authentication.model.SecurityPrincipal;
import com.kvnl.jwfe.security.authentication.repository.AuthenticationRepository;
import com.kvnl.jwfe.security.authentication.service.AuthenticationService;
import com.kvnl.jwfe.security.authentication.service.AuthorizationService;

public interface AuthenticationManagerContext<X extends SecurityPrincipal<Y>, Y extends SecurityAuthorization<Z>, Z extends SecurityAuthorizationResource> {

	AuthenticationConfiguration<X,Y,Z> getAuthenticationConfiguration();
	
	void setAuthenticationConfiguration(AuthenticationConfiguration<X,Y,Z> authenticationConfiguration);
	
	AuthenticationRepository<X,Y,Z> getAuthenticationRepository();
	
	void setAuthenticationRepository(AuthenticationRepository<X,Y,Z> authenticationRepository);
	
	AuthenticationService<X,Y,Z> getAuthenticationService();
	
	void setAuthenticationService(AuthenticationService<X,Y,Z> authenticationService);
	
	AuthorizationService<X,Y,Z> getAuthorizationService();
	
	void setAuthorizationService(AuthorizationService<X,Y,Z> authorizationService);
	
}
