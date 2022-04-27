package com.kvnl.jwfe.security.authentication.model;

public interface SecurityPrincipal<T extends SecurityAuthorization> {

	T getAuthorization();
	
	void setAuthorization(T authorization);
	
}
