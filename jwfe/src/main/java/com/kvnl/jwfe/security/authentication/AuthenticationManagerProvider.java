package com.kvnl.jwfe.security.authentication;

import com.kvnl.jwfe.security.authentication.model.SecurityAuthorization;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorizationResource;
import com.kvnl.jwfe.security.authentication.model.SecurityPrincipal;

public interface AuthenticationManagerProvider<X extends SecurityPrincipal<Y>, Y extends SecurityAuthorization<Z>, Z extends SecurityAuthorizationResource<?>> extends AuthenticationManagerContext<X, Y, Z> {

	AuthenticationManagerContext<X, Y, Z> getContext();
	
}
