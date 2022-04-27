package com.kvnl.jwfe.security.authentication.model;

public interface SecurityAuthorizationResource<T> {

	T getAuthorizationResource();
	
	void setAuthorizationResource(T authorizationResource);
	
}
